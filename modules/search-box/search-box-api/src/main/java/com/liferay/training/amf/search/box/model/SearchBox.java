/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.amf.search.box.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the SearchBox service. Represents a row in the &quot;SearchBox_SearchBox&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SearchBoxModel
 * @see com.liferay.training.amf.search.box.model.impl.SearchBoxImpl
 * @see com.liferay.training.amf.search.box.model.impl.SearchBoxModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.training.amf.search.box.model.impl.SearchBoxImpl")
@ProviderType
public interface SearchBox extends SearchBoxModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.training.amf.search.box.model.impl.SearchBoxImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SearchBox, Long> FOO_ID_ACCESSOR = new Accessor<SearchBox, Long>() {
			@Override
			public Long get(SearchBox searchBox) {
				return searchBox.getFooId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SearchBox> getTypeClass() {
				return SearchBox.class;
			}
		};
}