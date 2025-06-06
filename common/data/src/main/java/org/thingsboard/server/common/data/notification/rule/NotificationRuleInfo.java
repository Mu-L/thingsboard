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
package org.thingsboard.server.common.data.notification.rule;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NotificationRuleInfo extends NotificationRule {

    private String templateName;
    private List<NotificationDeliveryMethod> deliveryMethods;

    public NotificationRuleInfo(NotificationRule rule, String templateName, List<NotificationDeliveryMethod> deliveryMethods) {
        super(rule);
        this.templateName = templateName;
        this.deliveryMethods = deliveryMethods;
    }

}
