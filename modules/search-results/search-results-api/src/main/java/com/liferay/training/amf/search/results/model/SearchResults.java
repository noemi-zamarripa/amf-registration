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

package com.liferay.training.amf.search.results.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the SearchResults service. Represents a row in the &quot;SearchResults_SearchResults&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SearchResultsModel
 * @see com.liferay.training.amf.search.results.model.impl.SearchResultsImpl
 * @see com.liferay.training.amf.search.results.model.impl.SearchResultsModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.training.amf.search.results.model.impl.SearchResultsImpl")
@ProviderType
public interface SearchResults extends SearchResultsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.training.amf.search.results.model.impl.SearchResultsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SearchResults, Long> FOO_ID_ACCESSOR = new Accessor<SearchResults, Long>() {
			@Override
			public Long get(SearchResults searchResults) {
				return searchResults.getFooId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SearchResults> getTypeClass() {
				return SearchResults.class;
			}
		};
}