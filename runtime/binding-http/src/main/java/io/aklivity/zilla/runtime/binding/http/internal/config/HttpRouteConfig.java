/*
 * Copyright 2021-2022 Aklivity Inc.
 *
 * Aklivity licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.aklivity.zilla.runtime.binding.http.internal.config;

import static java.util.stream.Collectors.toList;

import java.util.List;

import io.aklivity.zilla.runtime.engine.config.OptionsConfig;
import io.aklivity.zilla.runtime.engine.config.RouteConfig;

public final class HttpRouteConfig extends OptionsConfig
{
    public final long id;
    public List<HttpConditionMatcher> when;

    public HttpRouteConfig(
        RouteConfig route)
    {
        this.id = route.id;
        this.when = route.when.stream()
            .map(HttpConditionConfig.class::cast)
            .map(HttpConditionMatcher::new)
            .collect(toList());
    }
}