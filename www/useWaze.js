/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
function UseWaze() { };

/*
 * Search for address
 */
UseWaze.prototype.search = function (q) {
	cordova.exec(null, null, "UseWaze", "search", [q]);
};

/*
 * Center map to latitude / longitude with zoom
 */
UseWaze.prototype.centerOnMap = function (latitude, longitude, zoom) {
	if (zoom && !isNaN(zoom))
	{
		if (zoom < 6)
			zoom = 6;
	}
	else
	{
		zoom = 6;
	}
		
	cordova.exec(null, null, "UseWaze", "centerOnMap", [latitude, longitude, zoom]);
};

/*
 * Navigate to latitude / longitude
 */
UseWaze.prototype.navigateTo = function (latitude, longitude) {
	cordova.exec(null, null, "UseWaze", "navigateTo", [latitude, longitude]);
};

module.exports = new UseWaze();
