/*
MIT License

Copyright (c) 2023 griffin-container
https://github.com/griffin-container/griffin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

'use strict';

const PRODUCT_VERSION = '1.01.01';
const CACHE_NAME_PREFIX = 'griffin-';
const FILE_NAME_HTML = "griffin.html";
const INDEX_URL = '/' + FILE_NAME_HTML;
const CACHE_NAME = CACHE_NAME_PREFIX + PRODUCT_VERSION;

/*
	@third-party: https://www.emakina.com

	We use modified and adapted code from:
	https://www.emakina.com/int-en/news/blog/post/offline-first-with-progressive-web-apps-caching-strategies-part-2-3
*/

self.addEventListener("install", function(event) {
	event.waitUntil(
		caches.open(CACHE_NAME).then(function(cache) {
			return cache.add(INDEX_URL);

		}).catch((err) => {
			console.error(err);
			return new Promise((resolve, reject) => {
				reject('ERROR: ' + err);
			});
		})
	);
});

self.addEventListener("fetch", function(event) {
	const requestURL = new URL(event.request.url);

	if (requestURL.pathname === '/') {
		event.respondWith(getByNetworkFallingBackByCache(INDEX_URL));
	} else if (INDEX_URL == requestURL.href ||
		INDEX_URL == requestURL.pathname) {
		event.respondWith(getByNetworkFallingBackByCache(event.request));
	}
});

self.addEventListener("activate", function(event) {
	event.waitUntil(
		caches.keys().then(function(cacheNames) {
			return Promise.all(
				cacheNames.map(function(cacheName) {
					if (CACHE_NAME !== cacheName && cacheName.startsWith(CACHE_NAME_PREFIX)) {
						return caches.delete(cacheName);
					}
				})
			);
		})
	);
});

/**
 * 1. We fetch the request over the network
 * 2. If successful we add the new response to the cache
 * 3. If failed we return the result from the cache
 *
 * @param request
 * @param showAlert
 * @returns Promise
 */
const getByNetworkFallingBackByCache = (request, showAlert = false) => {
	return caches.open(CACHE_NAME).then((cache) => {
		return fetch(request).then((networkResponse) => {
			cache.put(request, networkResponse.clone());
			return networkResponse;
		}).catch(() => {
			if (showAlert) {
				alert('You are in offline mode. The data may be outdated.')
			}

			return caches.match(request);
		});
	});
};
