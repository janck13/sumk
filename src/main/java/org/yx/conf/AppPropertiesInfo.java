/**
 * Copyright (C) 2016 - 2030 youtongluan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.yx.conf;

import java.io.InputStream;

public class AppPropertiesInfo extends PropertiesInfo {
	private volatile boolean started;

	AppPropertiesInfo() {
		super(System.getProperty("appinfo", "app.properties"));
	}

	@Override
	public void deal(InputStream in) throws Exception {
		super.deal(in);
		AppInfo.notifyUpdate();
	}

	@Override
	public synchronized void initAppInfo() {
		if (started) {
			return;
		}
		started = true;
		this.start();
	}
}
