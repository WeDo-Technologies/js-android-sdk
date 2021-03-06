/*
 * Copyright (C) 2012-2013 Jaspersoft Corporation. All rights reserved.
 * http://community.jaspersoft.com/project/mobile-sdk-android
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of Jaspersoft Mobile SDK for Android.
 *
 * Jaspersoft Mobile SDK is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Jaspersoft Mobile SDK is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Jaspersoft Mobile SDK for Android. If not, see
 * <http://www.gnu.org/licenses/lgpl>.
 */

package com.jaspersoft.android.sdk.client.async.request.cacheable;

import com.jaspersoft.android.sdk.client.JsRestClient;
import com.jaspersoft.android.sdk.client.JsServerProfile;
import com.jaspersoft.android.sdk.client.async.request.BaseRequest;

/**
 * A request that contains results that may be cached.
 * Provides additional functionality for cache key generation.
 *
 * @author Ivan Gadzhega
 * @since 1.6
 */
public abstract class CacheableRequest<T> extends BaseRequest<T> {

    public CacheableRequest(JsRestClient jsRestClient, Class<T> clazz) {
        super(jsRestClient, clazz);
    }

    public int createCacheKey() {
        return createCacheKeyString().hashCode();
    }

    protected String createCacheKeyString() {
        JsServerProfile profile = getJsRestClient().getServerProfile();
        return createCacheKeyTag() + profile.getServerUrl() + profile.getOrganization() + profile.getUsername();
    }

    protected String createCacheKeyTag() {
        return getClass().getName();
    }

}
