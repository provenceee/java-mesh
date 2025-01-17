/*
 * Copyright (C) 2023-2023 Huawei Technologies Co., Ltd. All rights reserved.
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

package io.sermant.router.dubbo.service;

import io.sermant.core.plugin.service.PluginService;

import java.util.List;
import java.util.Map;

/**
 * ContextFilter's service
 *
 * @author provenceee
 * @since 2023-02-16
 */
public interface LaneContextFilterService extends PluginService {
    /**
     * get swimlane markers
     *
     * @param interfaceName the name of the interface
     * @param methodName method name
     * @param attachments attachments
     * @param args interface parameters
     * @return swimlane markers
     */
    Map<String, List<String>> getLane(String interfaceName, String methodName, Map<String, Object> attachments,
            Object[] args);
}
