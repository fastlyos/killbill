/*
 * Copyright 2010-2011 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.util.customfield.api;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.google.inject.Inject;
import com.ning.billing.util.api.CustomFieldUserApi;
import com.ning.billing.util.callcontext.CallContext;
import com.ning.billing.util.customfield.CustomField;
import com.ning.billing.util.customfield.dao.CustomFieldDao;
import com.ning.billing.util.dao.ObjectType;

public class DefaultCustomFieldUserApi implements CustomFieldUserApi {
    private final CustomFieldDao customFieldDao;

    @Inject
    public DefaultCustomFieldUserApi(final CustomFieldDao customFieldDao) {
        this.customFieldDao = customFieldDao;
    }

    @Override
    public Map<String, CustomField> getCustomFields(final UUID objectId, final ObjectType objectType) {
        return customFieldDao.loadEntities(objectId, objectType);
    }

    @Override
    public void saveCustomFields(final UUID objectId, final ObjectType objectType, final List<CustomField> fields, final CallContext context) {
        customFieldDao.saveEntities(objectId, objectType, fields, context);
    }
}
