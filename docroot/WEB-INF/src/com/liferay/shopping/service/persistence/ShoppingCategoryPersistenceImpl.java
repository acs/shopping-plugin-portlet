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
import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.shopping.NoSuchCategoryException;
import com.liferay.shopping.model.ShoppingCategory;
import com.liferay.shopping.model.impl.ShoppingCategoryImpl;
import com.liferay.shopping.model.impl.ShoppingCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the shopping category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCategoryPersistence
 * @see ShoppingCategoryUtil
 * @generated
 */
public class ShoppingCategoryPersistenceImpl extends BasePersistenceImpl<ShoppingCategory>
	implements ShoppingCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ShoppingCategoryUtil} to access the shopping category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ShoppingCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(ShoppingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryModelImpl.FINDER_CACHE_ENABLED,
			ShoppingCategoryImpl.class, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ShoppingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_P = new FinderPath(ShoppingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryModelImpl.FINDER_CACHE_ENABLED,
			ShoppingCategoryImpl.class, FINDER_CLASS_NAME_LIST, "findByG_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_P = new FinderPath(ShoppingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByG_P",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ShoppingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryModelImpl.FINDER_CACHE_ENABLED,
			ShoppingCategoryImpl.class, FINDER_CLASS_NAME_LIST, "findAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the shopping category in the entity cache if it is enabled.
	 *
	 * @param shoppingCategory the shopping category
	 */
	public void cacheResult(ShoppingCategory shoppingCategory) {
		EntityCacheUtil.putResult(ShoppingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryImpl.class, shoppingCategory.getPrimaryKey(),
			shoppingCategory);

		shoppingCategory.resetOriginalValues();
	}

	/**
	 * Caches the shopping categories in the entity cache if it is enabled.
	 *
	 * @param shoppingCategories the shopping categories
	 */
	public void cacheResult(List<ShoppingCategory> shoppingCategories) {
		for (ShoppingCategory shoppingCategory : shoppingCategories) {
			if (EntityCacheUtil.getResult(
						ShoppingCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingCategoryImpl.class,
						shoppingCategory.getPrimaryKey()) == null) {
				cacheResult(shoppingCategory);
			}
		}
	}

	/**
	 * Clears the cache for all shopping categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ShoppingCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ShoppingCategoryImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the shopping category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ShoppingCategory shoppingCategory) {
		EntityCacheUtil.removeResult(ShoppingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryImpl.class, shoppingCategory.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL, FINDER_ARGS_EMPTY);
	}

	/**
	 * Creates a new shopping category with the primary key. Does not add the shopping category to the database.
	 *
	 * @param categoryId the primary key for the new shopping category
	 * @return the new shopping category
	 */
	public ShoppingCategory create(long categoryId) {
		ShoppingCategory shoppingCategory = new ShoppingCategoryImpl();

		shoppingCategory.setNew(true);
		shoppingCategory.setPrimaryKey(categoryId);

		return shoppingCategory;
	}

	/**
	 * Removes the shopping category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the shopping category
	 * @return the shopping category that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a shopping category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingCategory remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the shopping category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the shopping category
	 * @return the shopping category that was removed
	 * @throws com.liferay.shopping.NoSuchCategoryException if a shopping category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategory remove(long categoryId)
		throws NoSuchCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ShoppingCategory shoppingCategory = (ShoppingCategory)session.get(ShoppingCategoryImpl.class,
					Long.valueOf(categoryId));

			if (shoppingCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
				}

				throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					categoryId);
			}

			return shoppingCategoryPersistence.remove(shoppingCategory);
		}
		catch (NoSuchCategoryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Removes the shopping category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shoppingCategory the shopping category
	 * @return the shopping category that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingCategory remove(ShoppingCategory shoppingCategory)
		throws SystemException {
		return super.remove(shoppingCategory);
	}

	@Override
	protected ShoppingCategory removeImpl(ShoppingCategory shoppingCategory)
		throws SystemException {
		shoppingCategory = toUnwrappedModel(shoppingCategory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, shoppingCategory);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ShoppingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryImpl.class, shoppingCategory.getPrimaryKey());

		return shoppingCategory;
	}

	@Override
	public ShoppingCategory updateImpl(
		com.liferay.shopping.model.ShoppingCategory shoppingCategory,
		boolean merge) throws SystemException {
		shoppingCategory = toUnwrappedModel(shoppingCategory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, shoppingCategory, merge);

			shoppingCategory.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ShoppingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryImpl.class, shoppingCategory.getPrimaryKey(),
			shoppingCategory);

		return shoppingCategory;
	}

	protected ShoppingCategory toUnwrappedModel(
		ShoppingCategory shoppingCategory) {
		if (shoppingCategory instanceof ShoppingCategoryImpl) {
			return shoppingCategory;
		}

		ShoppingCategoryImpl shoppingCategoryImpl = new ShoppingCategoryImpl();

		shoppingCategoryImpl.setNew(shoppingCategory.isNew());
		shoppingCategoryImpl.setPrimaryKey(shoppingCategory.getPrimaryKey());

		shoppingCategoryImpl.setCategoryId(shoppingCategory.getCategoryId());
		shoppingCategoryImpl.setGroupId(shoppingCategory.getGroupId());
		shoppingCategoryImpl.setCompanyId(shoppingCategory.getCompanyId());
		shoppingCategoryImpl.setUserId(shoppingCategory.getUserId());
		shoppingCategoryImpl.setUserName(shoppingCategory.getUserName());
		shoppingCategoryImpl.setCreateDate(shoppingCategory.getCreateDate());
		shoppingCategoryImpl.setModifiedDate(shoppingCategory.getModifiedDate());
		shoppingCategoryImpl.setParentCategoryId(shoppingCategory.getParentCategoryId());
		shoppingCategoryImpl.setName(shoppingCategory.getName());
		shoppingCategoryImpl.setDescription(shoppingCategory.getDescription());

		return shoppingCategoryImpl;
	}

	/**
	 * Returns the shopping category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the shopping category
	 * @return the shopping category
	 * @throws com.liferay.portal.NoSuchModelException if a shopping category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the shopping category with the primary key or throws a {@link com.liferay.shopping.NoSuchCategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the shopping category
	 * @return the shopping category
	 * @throws com.liferay.shopping.NoSuchCategoryException if a shopping category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategory findByPrimaryKey(long categoryId)
		throws NoSuchCategoryException, SystemException {
		ShoppingCategory shoppingCategory = fetchByPrimaryKey(categoryId);

		if (shoppingCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
			}

			throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryId);
		}

		return shoppingCategory;
	}

	/**
	 * Returns the shopping category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the shopping category
	 * @return the shopping category, or <code>null</code> if a shopping category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the shopping category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the shopping category
	 * @return the shopping category, or <code>null</code> if a shopping category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategory fetchByPrimaryKey(long categoryId)
		throws SystemException {
		ShoppingCategory shoppingCategory = (ShoppingCategory)EntityCacheUtil.getResult(ShoppingCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingCategoryImpl.class, categoryId);

		if (shoppingCategory == _nullShoppingCategory) {
			return null;
		}

		if (shoppingCategory == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				shoppingCategory = (ShoppingCategory)session.get(ShoppingCategoryImpl.class,
						Long.valueOf(categoryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (shoppingCategory != null) {
					cacheResult(shoppingCategory);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ShoppingCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingCategoryImpl.class, categoryId,
						_nullShoppingCategory);
				}

				closeSession(session);
			}
		}

		return shoppingCategory;
	}

	/**
	 * Returns all the shopping categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching shopping categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCategory> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the shopping categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of shopping categories
	 * @param end the upper bound of the range of shopping categories (not inclusive)
	 * @return the range of matching shopping categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCategory> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the shopping categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of shopping categories
	 * @param end the upper bound of the range of shopping categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shopping categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCategory> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				start, end, orderByComparator
			};

		List<ShoppingCategory> list = (List<ShoppingCategory>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
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

			query.append(_SQL_SELECT_SHOPPINGCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ShoppingCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<ShoppingCategory>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first shopping category in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shopping category
	 * @throws com.liferay.shopping.NoSuchCategoryException if a matching shopping category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategory findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		List<ShoppingCategory> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last shopping category in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shopping category
	 * @throws com.liferay.shopping.NoSuchCategoryException if a matching shopping category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategory findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		int count = countByGroupId(groupId);

		List<ShoppingCategory> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the shopping categories before and after the current shopping category in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the primary key of the current shopping category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shopping category
	 * @throws com.liferay.shopping.NoSuchCategoryException if a shopping category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategory[] findByGroupId_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		ShoppingCategory shoppingCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			ShoppingCategory[] array = new ShoppingCategoryImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, shoppingCategory,
					groupId, orderByComparator, true);

			array[1] = shoppingCategory;

			array[2] = getByGroupId_PrevAndNext(session, shoppingCategory,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingCategory getByGroupId_PrevAndNext(Session session,
		ShoppingCategory shoppingCategory, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(ShoppingCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(shoppingCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the shopping categories where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @return the matching shopping categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCategory> findByG_P(long groupId, long parentCategoryId)
		throws SystemException {
		return findByG_P(groupId, parentCategoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the shopping categories where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of shopping categories
	 * @param end the upper bound of the range of shopping categories (not inclusive)
	 * @return the range of matching shopping categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCategory> findByG_P(long groupId,
		long parentCategoryId, int start, int end) throws SystemException {
		return findByG_P(groupId, parentCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the shopping categories where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of shopping categories
	 * @param end the upper bound of the range of shopping categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shopping categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCategory> findByG_P(long groupId,
		long parentCategoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, parentCategoryId,
				
				start, end, orderByComparator
			};

		List<ShoppingCategory> list = (List<ShoppingCategory>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_P,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SHOPPINGCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_PARENTCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ShoppingCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parentCategoryId);

				list = (List<ShoppingCategory>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_P,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_P,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first shopping category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shopping category
	 * @throws com.liferay.shopping.NoSuchCategoryException if a matching shopping category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategory findByG_P_First(long groupId,
		long parentCategoryId, OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		List<ShoppingCategory> list = findByG_P(groupId, parentCategoryId, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", parentCategoryId=");
			msg.append(parentCategoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last shopping category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shopping category
	 * @throws com.liferay.shopping.NoSuchCategoryException if a matching shopping category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategory findByG_P_Last(long groupId, long parentCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		int count = countByG_P(groupId, parentCategoryId);

		List<ShoppingCategory> list = findByG_P(groupId, parentCategoryId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", parentCategoryId=");
			msg.append(parentCategoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the shopping categories before and after the current shopping category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the primary key of the current shopping category
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shopping category
	 * @throws com.liferay.shopping.NoSuchCategoryException if a shopping category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategory[] findByG_P_PrevAndNext(long categoryId,
		long groupId, long parentCategoryId, OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		ShoppingCategory shoppingCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			ShoppingCategory[] array = new ShoppingCategoryImpl[3];

			array[0] = getByG_P_PrevAndNext(session, shoppingCategory, groupId,
					parentCategoryId, orderByComparator, true);

			array[1] = shoppingCategory;

			array[2] = getByG_P_PrevAndNext(session, shoppingCategory, groupId,
					parentCategoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingCategory getByG_P_PrevAndNext(Session session,
		ShoppingCategory shoppingCategory, long groupId, long parentCategoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_PARENTCATEGORYID_2);

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
			query.append(ShoppingCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(parentCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(shoppingCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the shopping categories.
	 *
	 * @return the shopping categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the shopping categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of shopping categories
	 * @param end the upper bound of the range of shopping categories (not inclusive)
	 * @return the range of shopping categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the shopping categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of shopping categories
	 * @param end the upper bound of the range of shopping categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of shopping categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCategory> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		List<ShoppingCategory> list = (List<ShoppingCategory>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SHOPPINGCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHOPPINGCATEGORY.concat(ShoppingCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ShoppingCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ShoppingCategory>)QueryUtil.list(q,
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
	 * Removes all the shopping categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (ShoppingCategory shoppingCategory : findByGroupId(groupId)) {
			shoppingCategoryPersistence.remove(shoppingCategory);
		}
	}

	/**
	 * Removes all the shopping categories where groupId = &#63; and parentCategoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_P(long groupId, long parentCategoryId)
		throws SystemException {
		for (ShoppingCategory shoppingCategory : findByG_P(groupId,
				parentCategoryId)) {
			shoppingCategoryPersistence.remove(shoppingCategory);
		}
	}

	/**
	 * Removes all the shopping categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ShoppingCategory shoppingCategory : findAll()) {
			shoppingCategoryPersistence.remove(shoppingCategory);
		}
	}

	/**
	 * Returns the number of shopping categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching shopping categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of shopping categories where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching shopping categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_P(long groupId, long parentCategoryId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, parentCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHOPPINGCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_PARENTCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parentCategoryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_P, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of shopping categories.
	 *
	 * @return the number of shopping categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SHOPPINGCATEGORY);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the shopping category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.shopping.model.ShoppingCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ShoppingCategory>> listenersList = new ArrayList<ModelListener<ShoppingCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ShoppingCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ShoppingCategoryImpl.class.getName());
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
	private static final String _SQL_SELECT_SHOPPINGCATEGORY = "SELECT shoppingCategory FROM ShoppingCategory shoppingCategory";
	private static final String _SQL_SELECT_SHOPPINGCATEGORY_WHERE = "SELECT shoppingCategory FROM ShoppingCategory shoppingCategory WHERE ";
	private static final String _SQL_COUNT_SHOPPINGCATEGORY = "SELECT COUNT(shoppingCategory) FROM ShoppingCategory shoppingCategory";
	private static final String _SQL_COUNT_SHOPPINGCATEGORY_WHERE = "SELECT COUNT(shoppingCategory) FROM ShoppingCategory shoppingCategory WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "shoppingCategory.groupId = ?";
	private static final String _FINDER_COLUMN_G_P_GROUPID_2 = "shoppingCategory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_P_PARENTCATEGORYID_2 = "shoppingCategory.parentCategoryId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ShoppingCategoryPersistenceImpl.class);
	private static ShoppingCategory _nullShoppingCategory = new ShoppingCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ShoppingCategory> toCacheModel() {
				return _nullShoppingCategoryCacheModel;
			}
		};

	private static CacheModel<ShoppingCategory> _nullShoppingCategoryCacheModel = new CacheModel<ShoppingCategory>() {
			public ShoppingCategory toEntityModel() {
				return _nullShoppingCategory;
			}
		};
}