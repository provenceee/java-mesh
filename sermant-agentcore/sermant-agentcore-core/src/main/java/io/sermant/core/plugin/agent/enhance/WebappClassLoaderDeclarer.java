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

package io.sermant.core.plugin.agent.enhance;

import io.sermant.core.plugin.agent.declarer.AbstractPluginDeclarer;
import io.sermant.core.plugin.agent.declarer.InterceptDeclarer;
import io.sermant.core.plugin.agent.matcher.ClassMatcher;
import io.sermant.core.plugin.agent.matcher.MethodMatcher;

public class WebappClassLoaderDeclarer extends AbstractPluginDeclarer {
    private static final String TOMCAT_CLASS_LOADER = "org.apache.catalina.loader.WebappClassLoaderBase";

    @Override
    public ClassMatcher getClassMatcher() {
        return ClassMatcher.nameEquals(TOMCAT_CLASS_LOADER);
    }

    @Override
    public InterceptDeclarer[] getInterceptDeclarers(ClassLoader classLoader) {
        return new InterceptDeclarer[] {
                InterceptDeclarer.build(MethodMatcher.nameEquals("loadClass"),
                        new ClassLoaderLoadClassInterceptor()),
                InterceptDeclarer.build(MethodMatcher.nameEquals("getResourceAsStream"),
                        new WebappClassLoaderInterceptor())};
    }
}
