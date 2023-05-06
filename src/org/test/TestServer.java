/**
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
package org.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class TestServer {
	private static boolean deleted = false;
	private static final int PORT = 8080;

	public static void main(String[] args) throws Exception {
		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println(PORT);

			while (true) {
				Socket clientSocket = serverSocket.accept();

				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

				String s;
				String method = null;
				String auth = null;
				String path = null;
				boolean firstLine = true;
				while ((s = in.readLine()) != null) {
					System.out.println(s);
					if (s.isEmpty())
						break;
					s = s.trim();
					if (firstLine) {
						firstLine = false;
						int pos = s.indexOf(' ');
						if (pos != -1)
							method = s.substring(0, pos).toUpperCase(Locale.ENGLISH);
						path = s.substring(pos + 1);
						int pos2 = path.indexOf(' ');
						path = path.substring(0, pos2);
					} else {
						if (s.toUpperCase(Locale.ENGLISH).startsWith("Authorization:".toUpperCase(Locale.ENGLISH))) {
							int pos = s.indexOf(':');
							if (pos != -1)
								auth = s.substring(pos + 1).trim();
						}
					}
				}
				//
				System.out.println("Method: " + method);
				System.out.println("Path: " + path);
				//
				if ("GET".equals(method)) {
					if (deleted) {
						out.write("HTTP/1.0 200 OK\r\n");
						out.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
						out.write("Server: Apache/0.8.4\r\n");
						out.write("Content-Type: text/html\r\n");
						out.write("Content-Length: 0\r\n");
						out.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
						out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
						out.write("Access-Control-Allow-Origin: *\r\n");
						out.write("Access-Control-Allow-Methods: *\r\n");
						out.write("\r\n");
					} else {
						if (auth.equals("Bearer 1234567890")) {						
							out.write("HTTP/1.0 200 OK\r\n");
							out.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
							out.write("Server: Apache/0.8.4\r\n");
							out.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
							out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
							out.write("Access-Control-Allow-Origin: *\r\n");
							out.write("Access-Control-Allow-Methods: *\r\n");
							out.write("\r\n");
							out.write("2bMjpn56eLEutHVWpcRPmHGifJIfQLqivN5YUirvgN6R18uGU7hnKt8mjZUMo8tf");
						} else {
							out.write("HTTP/1.0 403 Forbidden\r\n");
							out.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
							out.write("Server: Apache/0.8.4\r\n");
							out.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
							out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
							out.write("Access-Control-Allow-Origin: *\r\n");
							out.write("Access-Control-Allow-Methods: *\r\n");
							out.write("\r\n");
						}
					}
				} else if ("OPTIONS".equals(method)) {
					out.write("HTTP/1.0 204 No Content\r\n");
					out.write("Content-Length: 0\r\n");
					out.write("Allow: *\r\n");
					out.write("Access-Control-Allow-Origin: *\r\n");
					out.write("Access-Control-Allow-Methods: *\r\n");
					out.write("Access-Control-Allow-Headers: *\r\n");
					out.write("\r\n");
				} else if ("HEAD".equals(method)) {
					out.write("HTTP/1.0 400 OK\r\n");
					out.write("Access-Control-Allow-Origin: *\r\n");
					out.write("Access-Control-Allow-Methods: *\r\n");
					out.write("\r\n");
				} else if ("DELETE".equals(method)) {
					if (auth.equals("Bearer 1234567890")) {						
						deleted = true;
						out.write("HTTP/1.0 200 OK\r\n");
						out.write("Content-Length: 0\r\n");
						out.write("Access-Control-Allow-Origin: *\r\n");
						out.write("Access-Control-Allow-Methods: *\r\n");
						out.write("\r\n");
					} else {
						out.write("HTTP/1.0 403 Forbidden\r\n");
						out.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
						out.write("Server: Apache/0.8.4\r\n");
						out.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
						out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
						out.write("Access-Control-Allow-Origin: *\r\n");
						out.write("Access-Control-Allow-Methods: *\r\n");
						out.write("\r\n");						
					}
				}
				out.close();
				in.close();
				clientSocket.close();
			}
		}
	}
}
