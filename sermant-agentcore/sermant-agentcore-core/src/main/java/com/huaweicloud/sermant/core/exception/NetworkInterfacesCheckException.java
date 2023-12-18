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

package com.huaweicloud.sermant.core.exception;

/**
 * 网络接口检查异常
 *
 * @author luanwenfei
 * @since 2023-12-18
 */
public class NetworkInterfacesCheckException extends RuntimeException {
    /**
     * 网络接口检查异常
     *
     * @param message 异常信息
     */
    public NetworkInterfacesCheckException(String message) {
        super(message);
    }
}
