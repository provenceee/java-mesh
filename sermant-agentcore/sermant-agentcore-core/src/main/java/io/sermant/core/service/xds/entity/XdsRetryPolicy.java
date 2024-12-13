/*
 * Copyright (C) 2024-2024 Sermant Authors. All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package io.sermant.core.service.xds.entity;

/**
 * Xds Retry Policy information
 *
 * @author zhp
 * @since 2024-11-18
 */
public class XdsRetryPolicy {
    /**
     * The maximum number of times host selection will be reattempted before giving up, at which point the host
     * that was last selected will be routed to
     */
    private long maxAttempts;

    /**
     * Specifies a non-zero upstream timeout per retry attempt (including the initial attempt)
     */
    private long perTryTimeout;

    /**
     * Specifies the conditions under which retry takes place
     */
    private String retryOn;

    /**
     * Specifies the conditions under which retry takes place
     */
    private String retryHostPredicate;

    public long getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(long maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public long getPerTryTimeout() {
        return perTryTimeout;
    }

    public void setPerTryTimeout(long perTryTimeout) {
        this.perTryTimeout = perTryTimeout;
    }

    public String getRetryOn() {
        return retryOn;
    }

    public void setRetryOn(String retryOn) {
        this.retryOn = retryOn;
    }

    public String getRetryHostPredicate() {
        return retryHostPredicate;
    }

    public void setRetryHostPredicate(String retryHostPredicate) {
        this.retryHostPredicate = retryHostPredicate;
    }
}