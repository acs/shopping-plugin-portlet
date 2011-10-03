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

package com.liferay.shopping.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.shopping.NoSuchItemFieldException;
import com.liferay.shopping.model.ShoppingItemField;
import com.liferay.shopping.model.impl.ShoppingItemFieldImpl;
import com.liferay.shopping.model.impl.ShoppingItemFieldModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the shopping item field service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ShoppingItemFieldUtil} to access the shopping item field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemFieldPersistence
 * @see ShoppingItemFieldUtil
 * @generated
 */
public class ShoppingItemFieldPersistenceImpl extends BasePersistenceImpl<ShoppingItemField>
	implements ShoppingItemFieldPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ShoppingItemFieldImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ITEMID = new FinderPath(ShoppingItemFieldModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemFieldModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByItemId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMID = new FinderPath(ShoppingItemFieldModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemFieldModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByItemId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ShoppingItemFieldModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemFieldModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingItemFieldModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemFieldModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the shopping item field in the entity cache if it is enabled.
	 *
	 * @param shoppingItemField the shopping item field to cache
	 */
	public void cacheResult(ShoppingItemField shoppingItemField) {
		EntityCacheUtil.putResult(ShoppingItemFieldModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemFieldImpl.class, shoppingItemField.getPrimaryKey(),
			shoppingItemField);
	}

	/**
	 * Caches the shopping item fields in the entity cache if it is enabled.
	 *
	 * @param shoppingItemFields the shopping item fields to cache
	 */
	public void cacheResult(List<ShoppingItemField> shoppingItemFields) {
		for (ShoppingItemField shoppingItemField : shoppingItemFields) {
			if (EntityCacheUtil.getResult(
						ShoppingItemFieldModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingItemFieldImpl.class,
						shoppingItemField.getPrimaryKey(), this) == null) {
				cacheResult(shoppingItemField);
			}
		}
	}

	/**
	 * Clears the cache for all shopping item fields.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ShoppingItemFieldImpl.class.getName());
		EntityCacheUtil.clearCache(ShoppingItemFieldImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the shopping item field.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ShoppingItemField shoppingItemField) {
		EntityCacheUtil.removeResult(ShoppingItemFieldModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemFieldImpl.class, shoppingItemField.getPrimaryKey());
	}

	/**
	 * Creates a new shopping item field with the primary key. Does not add the shopping item field to the database.
	 *
	 * @param itemFieldId the primary key for the new shopping item field
	 * @return the new shopping item field
	 */
	public ShoppingItemField create(long itemFieldId) {
		ShoppingItemField shoppingItemField = new ShoppingItemFieldImpl();

		shoppingItemField.setNew(true);
		shoppingItemField.setPrimaryKey(itemFieldId);

		return shoppingItemField;
	}

	/**
	 * Removes the shopping item field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the shopping item field to remove
	 * @return the shopping item field that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a shopping item field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemField remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the shopping item field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemFieldId the primary key of the shopping item field to remove
	 * @return the shopping item field that was removed
	 * @throws com.liferay.shopping.NoSuchItemFieldException if a shopping item field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemField remove(long itemFieldId)
		throws NoSuchItemFieldException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ShoppingItemField shoppingItemField = (ShoppingItemField)session.get(ShoppingItemFieldImpl.class,
					new Long(itemFieldId));

			if (shoppingItemField == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + itemFieldId);
				}

				throw new NoSuchItemFieldException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					itemFieldId);
			}

			return remove(shoppingItemField);
		}
		catch (NoSuchItemFieldException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingItemField removeImpl(ShoppingItemField shoppingItemField)
		throws SystemException {
		shoppingItemField = toUnwrappedModel(shoppingItemField);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, shoppingItemField);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ShoppingItemFieldModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemFieldImpl.class, shoppingItemField.getPrimaryKey());

		return shoppingItemField;
	}

	public ShoppingItemField updateImpl(
		com.liferay.shopping.model.ShoppingItemField shoppingItemField,
		boolean merge) throws SystemException {
		shoppingItemField = toUnwrappedModel(shoppingItemField);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, shoppingItemField, merge);

			shoppingItemField.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ShoppingItemFieldModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemFieldImpl.class, shoppingItemField.getPrimaryKey(),
			shoppingItemField);

		return shoppingItemField;
	}

	protected ShoppingItemField toUnwrappedModel(
		ShoppingItemField shoppingItemField) {
		if (shoppingItemField instanceof ShoppingItemFieldImpl) {
			return shoppingItemField;
		}

		ShoppingItemFieldImpl shoppingItemFieldImpl = new ShoppingItemFieldImpl();

		shoppingItemFieldImpl.setNew(shoppingItemField.isNew());
		shoppingItemFieldImpl.setPrimaryKey(shoppingItemField.getPrimaryKey());

		shoppingItemFieldImpl.setItemFieldId(shoppingItemField.getItemFieldId());
		shoppingItemFieldImpl.setItemId(shoppingItemField.getItemId());
		shoppingItemFieldImpl.setName(shoppingItemField.getName());
		shoppingItemFieldImpl.setValues(shoppingItemField.getValues());
		shoppingItemFieldImpl.setDescription(shoppingItemField.getDescription());

		return shoppingItemFieldImpl;
	}

	/**
	 * Finds the shopping item field with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the shopping item field to find
	 * @return the shopping item field
	 * @throws com.liferay.portal.NoSuchModelException if a shopping item field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemField findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the shopping item field with the primary key or throws a {@link com.liferay.shopping.NoSuchItemFieldException} if it could not be found.
	 *
	 * @param itemFieldId the primary key of the shopping item field to find
	 * @return the shopping item field
	 * @throws com.liferay.shopping.NoSuchItemFieldException if a shopping item field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemField findByPrimaryKey(long itemFieldId)
		throws NoSuchItemFieldException, SystemException {
		ShoppingItemField shoppingItemField = fetchByPrimaryKey(itemFieldId);

		if (shoppingItemField == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + itemFieldId);
			}

			throw new NoSuchItemFieldException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				itemFieldId);
		}

		return shoppingItemField;
	}

	/**
	 * Finds the shopping item field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the shopping item field to find
	 * @return the shopping item field, or <code>null</code> if a shopping item field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemField fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the shopping item field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemFieldId the primary key of the shopping item field to find
	 * @return the shopping item field, or <code>null</code> if a shopping item field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemField fetchByPrimaryKey(long itemFieldId)
		throws SystemException {
		ShoppingItemField shoppingItemField = (ShoppingItemField)EntityCacheUtil.getResult(ShoppingItemFieldModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingItemFieldImpl.class, itemFieldId, this);

		if (shoppingItemField == null) {
			Session session = null;

			try {
				session = openSession();

				shoppingItemField = (ShoppingItemField)session.get(ShoppingItemFieldImpl.class,
						new Long(itemFieldId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (shoppingItemField != null) {
					cacheResult(shoppingItemField);
				}

				closeSession(session);
			}
		}

		return shoppingItemField;
	}

	/**
	 * Finds all the shopping item fields where itemId = &#63;.
	 *
	 * @param itemId the item id to search with
	 * @return the matching shopping item fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItemField> findByItemId(long itemId)
		throws SystemException {
		return findByItemId(itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the shopping item fields where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param itemId the item id to search with
	 * @param start the lower bound of the range of shopping item fields to return
	 * @param end the upper bound of the range of shopping item fields to return (not inclusive)
	 * @return the range of matching shopping item fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItemField> findByItemId(long itemId, int start, int end)
		throws SystemException {
		return findByItemId(itemId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the shopping item fields where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param itemId the item id to search with
	 * @param start the lower bound of the range of shopping item fields to return
	 * @param end the upper bound of the range of shopping item fields to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching shopping item fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItemField> findByItemId(long itemId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				itemId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ShoppingItemField> list = (List<ShoppingItemField>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ITEMID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SHOPPINGITEMFIELD_WHERE);

			query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ShoppingItemFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

				list = (List<ShoppingItemField>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_ITEMID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ITEMID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first shopping item field in the ordered set where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param itemId the item id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching shopping item field
	 * @throws com.liferay.shopping.NoSuchItemFieldException if a matching shopping item field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemField findByItemId_First(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchItemFieldException, SystemException {
		List<ShoppingItemField> list = findByItemId(itemId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("itemId=");
			msg.append(itemId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchItemFieldException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last shopping item field in the ordered set where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param itemId the item id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching shopping item field
	 * @throws com.liferay.shopping.NoSuchItemFieldException if a matching shopping item field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemField findByItemId_Last(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchItemFieldException, SystemException {
		int count = countByItemId(itemId);

		List<ShoppingItemField> list = findByItemId(itemId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("itemId=");
			msg.append(itemId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchItemFieldException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the shopping item fields before and after the current shopping item field in the ordered set where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param itemFieldId the primary key of the current shopping item field
	 * @param itemId the item id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next shopping item field
	 * @throws com.liferay.shopping.NoSuchItemFieldException if a shopping item field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemField[] findByItemId_PrevAndNext(long itemFieldId,
		long itemId, OrderByComparator orderByComparator)
		throws NoSuchItemFieldException, SystemException {
		ShoppingItemField shoppingItemField = findByPrimaryKey(itemFieldId);

		Session session = null;

		try {
			session = openSession();

			ShoppingItemField[] array = new ShoppingItemFieldImpl[3];

			array[0] = getByItemId_PrevAndNext(session, shoppingItemField,
					itemId, orderByComparator, true);

			array[1] = shoppingItemField;

			array[2] = getByItemId_PrevAndNext(session, shoppingItemField,
					itemId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingItemField getByItemId_PrevAndNext(Session session,
		ShoppingItemField shoppingItemField, long itemId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGITEMFIELD_WHERE);

		query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ShoppingItemFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(itemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(shoppingItemField);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingItemField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the shopping item fields.
	 *
	 * @return the shopping item fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItemField> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the shopping item fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of shopping item fields to return
	 * @param end the upper bound of the range of shopping item fields to return (not inclusive)
	 * @return the range of shopping item fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItemField> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the shopping item fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of shopping item fields to return
	 * @param end the upper bound of the range of shopping item fields to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of shopping item fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItemField> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ShoppingItemField> list = (List<ShoppingItemField>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SHOPPINGITEMFIELD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHOPPINGITEMFIELD.concat(ShoppingItemFieldModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ShoppingItemField>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ShoppingItemField>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the shopping item fields where itemId = &#63; from the database.
	 *
	 * @param itemId the item id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByItemId(long itemId) throws SystemException {
		for (ShoppingItemField shoppingItemField : findByItemId(itemId)) {
			remove(shoppingItemField);
		}
	}

	/**
	 * Removes all the shopping item fields from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ShoppingItemField shoppingItemField : findAll()) {
			remove(shoppingItemField);
		}
	}

	/**
	 * Counts all the shopping item fields where itemId = &#63;.
	 *
	 * @param itemId the item id to search with
	 * @return the number of matching shopping item fields
	 * @throws SystemException if a system exception occurred
	 */
	public int countByItemId(long itemId) throws SystemException {
		Object[] finderArgs = new Object[] { itemId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ITEMID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGITEMFIELD_WHERE);

			query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ITEMID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the shopping item fields.
	 *
	 * @return the number of shopping item fields
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SHOPPINGITEMFIELD);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the shopping item field persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.shopping.model.ShoppingItemField")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ShoppingItemField>> listenersList = new ArrayList<ModelListener<ShoppingItemField>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ShoppingItemField>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ShoppingItemFieldImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = ShoppingCartPersistence.class)
	protected ShoppingCartPersistence shoppingCartPersistence;
	@BeanReference(type = ShoppingCategoryPersistence.class)
	protected ShoppingCategoryPersistence shoppingCategoryPersistence;
	@BeanReference(type = ShoppingCouponPersistence.class)
	protected ShoppingCouponPersistence shoppingCouponPersistence;
	@BeanReference(type = ShoppingItemPersistence.class)
	protected ShoppingItemPersistence shoppingItemPersistence;
	@BeanReference(type = ShoppingItemFieldPersistence.class)
	protected ShoppingItemFieldPersistence shoppingItemFieldPersistence;
	@BeanReference(type = ShoppingItemPricePersistence.class)
	protected ShoppingItemPricePersistence shoppingItemPricePersistence;
	@BeanReference(type = ShoppingOrderPersistence.class)
	protected ShoppingOrderPersistence shoppingOrderPersistence;
	@BeanReference(type = ShoppingOrderItemPersistence.class)
	protected ShoppingOrderItemPersistence shoppingOrderItemPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_SHOPPINGITEMFIELD = "SELECT shoppingItemField FROM ShoppingItemField shoppingItemField";
	private static final String _SQL_SELECT_SHOPPINGITEMFIELD_WHERE = "SELECT shoppingItemField FROM ShoppingItemField shoppingItemField WHERE ";
	private static final String _SQL_COUNT_SHOPPINGITEMFIELD = "SELECT COUNT(shoppingItemField) FROM ShoppingItemField shoppingItemField";
	private static final String _SQL_COUNT_SHOPPINGITEMFIELD_WHERE = "SELECT COUNT(shoppingItemField) FROM ShoppingItemField shoppingItemField WHERE ";
	private static final String _FINDER_COLUMN_ITEMID_ITEMID_2 = "shoppingItemField.itemId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingItemField.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingItemField exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingItemField exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ShoppingItemFieldPersistenceImpl.class);
}