/**
 * Copyright © 2016-2025 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.lwm2m.server.ota.software;

public enum LwM2MSoftwareUpdateStrategy {
    BINARY(1, "ObjectId 9, Binary"),
    TEMP_URL(2, "ObjectId 9, URI");

    public int code;
    public String type;

    LwM2MSoftwareUpdateStrategy(int code, String type) {
        this.code = code;
        this.type = type;
    }

    public static LwM2MSoftwareUpdateStrategy fromStrategySwByType(String type) {
        for (LwM2MSoftwareUpdateStrategy to : LwM2MSoftwareUpdateStrategy.values()) {
            if (to.type.equals(type)) {
                return to;
            }
        }
        throw new IllegalArgumentException(String.format("Unsupported SW Strategy type  : %s", type));
    }

    public static LwM2MSoftwareUpdateStrategy fromStrategySwByCode(int code) {
        for (LwM2MSoftwareUpdateStrategy to : LwM2MSoftwareUpdateStrategy.values()) {
            if (to.code == code) {
                return to;
            }
        }
        throw new IllegalArgumentException(String.format("Unsupported SW Strategy code : %s", code));
    }

}
