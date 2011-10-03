/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.shopping.model;

/**
 * The model interface for the ShoppingCategory service. Represents a row in the &quot;Shopping_ShoppingCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.shopping.model.impl.ShoppingCategoryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. All methods that expect a shopping category model instance should use the {@link ShoppingCategory} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCategoryModel
 * @see com.liferay.shopping.model.impl.ShoppingCategoryImpl
 * @see com.liferay.shopping.model.impl.ShoppingCategoryModelImpl
 * @generated
 */
public interface ShoppingCategory extends ShoppingCategoryModel {
	public boolean isRoot();
}