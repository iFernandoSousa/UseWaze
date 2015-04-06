<!---
 license: Licensed to the Apache Software Foundation (ASF) under one
         or more contributor license agreements.  See the NOTICE file
         distributed with this work for additional information
         regarding copyright ownership.  The ASF licenses this file
         to you under the Apache License, Version 2.0 (the
         "License"); you may not use this file except in compliance
         with the License.  You may obtain a copy of the License at

           http://www.apache.org/licenses/LICENSE-2.0

         Unless required by applicable law or agreed to in writing,
         software distributed under the License is distributed on an
         "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
         KIND, either express or implied.  See the License for the
         specific language governing permissions and limitations
         under the License.
-->
# UseWaze
Allow call waze with Intent for Android

#### Installation

For Cordova:

    cordova plugin add https://github.com/iFernandoSousa/UseWaze.git

#### Using the plugin
You can call Waze to search any location

    UseWaze.search("Avenida Paulista, São Paulo");

You can center in a specific latitude and longitude

    UseWaze.centerOnMap(-23.5626773,-46.6551163);
And you can set the zoom you want, the default zoom is 6
    
    UseWaze.centerOnMap(-23.5626773,-46.6551163, 10);

You can navigate to specific latitude and longitude:

    UseWaze.centerOnMap(-23.5626773,-46.6551163, 10);
