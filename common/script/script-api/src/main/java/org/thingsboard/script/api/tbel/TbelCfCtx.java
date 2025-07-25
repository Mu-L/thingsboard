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
package org.thingsboard.script.api.tbel;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;

public class TbelCfCtx implements TbelCfObject {

    @Getter
    private final Map<String, TbelCfArg> args;
    @Getter
    private final long latestTs;

    public TbelCfCtx(Map<String, TbelCfArg> args, long latestTs) {
        this.args = Collections.unmodifiableMap(args);
        this.latestTs = latestTs != -1 ? latestTs : System.currentTimeMillis();
    }

    @Override
    public long memorySize() {
        return OBJ_SIZE;
    }
}
