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

import com.liferay.shopping.NoSuchCartException;
import com.liferay.shopping.model.ShoppingCart;
import com.liferay.shopping.model.impl.ShoppingCartImpl;
import com.liferay.shopping.model.impl.ShoppingCartModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the shopping cart service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ShoppingCartUtil} to access the shopping cart persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCartPersistence
 * @see ShoppingCartUtil
 * @generated
 */
public class ShoppingCartPersistenceImpl extends BasePersistenceImpl<ShoppingCart>
	implements ShoppingCartPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ShoppingCartImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(ShoppingCartModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ShoppingCartModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(ShoppingCartModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ShoppingCartModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUserId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_G_U = new FinderPath(ShoppingCartModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_U",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_G_U = new FinderPath(ShoppingCartModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_U",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ShoppingCartModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingCartModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the shopping cart in the entity cache if it is enabled.
	 *
	 * @param shoppingCart the shopping cart to cache
	 */
	public void cacheResult(ShoppingCart shoppingCart) {
		EntityCacheUtil.putResult(ShoppingCartModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartImpl.class, shoppingCart.getPrimaryKey(), shoppingCart);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_U,
			new Object[] {
				new Long(shoppingCart.getGroupId()),
				new Long(shoppingCart.getUserId())
			}, shoppingCart);
	}

	/**
	 * Caches the shopping carts in the entity cache if it is enabled.
	 *
	 * @param shoppingCarts the shopping carts to cache
	 */
	public void cacheResult(List<ShoppingCart> shoppingCarts) {
		for (ShoppingCart shoppingCart : shoppingCarts) {
			if (EntityCacheUtil.getResult(
						ShoppingCartModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingCartImpl.class, shoppingCart.getPrimaryKey(),
						this) == null) {
				cacheResult(shoppingCart);
			}
		}
	}

	/**
	 * Clears the cache for all shopping carts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ShoppingCartImpl.class.getName());
		EntityCacheUtil.clearCache(ShoppingCartImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the shopping cart.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ShoppingCart shoppingCart) {
		EntityCacheUtil.removeResult(ShoppingCartModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartImpl.class, shoppingCart.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_U,
			new Object[] {
				new Long(shoppingCart.getGroupId()),
				new Long(shoppingCart.getUserId())
			});
	}

	/**
	 * Creates a new shopping cart with the primary key. Does not add the shopping cart to the database.
	 *
	 * @param cartId the primary key for the new shopping cart
	 * @return the new shopping cart
	 */
	public ShoppingCart create(long cartId) {
		ShoppingCart shoppingCart = new ShoppingCartImpl();

		shoppingCart.setNew(true);
		shoppingCart.setPrimaryKey(cartId);

		return shoppingCart;
	}

	/**
	 * Removes the shopping cart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the shopping cart to remove
	 * @return the shopping cart that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a shopping cart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the shopping cart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cartId the primary key of the shopping cart to remove
	 * @return the shopping cart that was removed
	 * @throws com.liferay.shopping.NoSuchCartException if a shopping cart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart remove(long cartId)
		throws NoSuchCartException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ShoppingCart shoppingCart = (ShoppingCart)session.get(ShoppingCartImpl.class,
					new Long(cartId));

			if (shoppingCart == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + cartId);
				}

				throw new NoSuchCartException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					cartId);
			}

			return remove(shoppingCart);
		}
		catch (NoSuchCartException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingCart removeImpl(ShoppingCart shoppingCart)
		throws SystemException {
		shoppingCart = toUnwrappedModel(shoppingCart);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, shoppingCart);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		ShoppingCartModelImpl shoppingCartModelImpl = (ShoppingCartModelImpl)shoppingCart;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_U,
			new Object[] {
				new Long(shoppingCartModelImpl.getGroupId()),
				new Long(shoppingCartModelImpl.getUserId())
			});

		EntityCacheUtil.removeResult(ShoppingCartModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartImpl.class, shoppingCart.getPrimaryKey());

		return shoppingCart;
	}

	public ShoppingCart updateImpl(
		com.liferay.shopping.model.ShoppingCart shoppingCart, boolean merge)
		throws SystemException {
		shoppingCart = toUnwrappedModel(shoppingCart);

		boolean isNew = shoppingCart.isNew();

		ShoppingCartModelImpl shoppingCartModelImpl = (ShoppingCartModelImpl)shoppingCart;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, shoppingCart, merge);

			shoppingCart.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ShoppingCartModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartImpl.class, shoppingCart.getPrimaryKey(), shoppingCart);

		if (!isNew &&
				((shoppingCart.getGroupId() != shoppingCartModelImpl.getOriginalGroupId()) ||
				(shoppingCart.getUserId() != shoppingCartModelImpl.getOriginalUserId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_U,
				new Object[] {
					new Long(shoppingCartModelImpl.getOriginalGroupId()),
					new Long(shoppingCartModelImpl.getOriginalUserId())
				});
		}

		if (isNew ||
				((shoppingCart.getGroupId() != shoppingCartModelImpl.getOriginalGroupId()) ||
				(shoppingCart.getUserId() != shoppingCartModelImpl.getOriginalUserId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_U,
				new Object[] {
					new Long(shoppingCart.getGroupId()),
					new Long(shoppingCart.getUserId())
				}, shoppingCart);
		}

		return shoppingCart;
	}

	protected ShoppingCart toUnwrappedModel(ShoppingCart shoppingCart) {
		if (shoppingCart instanceof ShoppingCartImpl) {
			return shoppingCart;
		}

		ShoppingCartImpl shoppingCartImpl = new ShoppingCartImpl();

		shoppingCartImpl.setNew(shoppingCart.isNew());
		shoppingCartImpl.setPrimaryKey(shoppingCart.getPrimaryKey());

		shoppingCartImpl.setCartId(shoppingCart.getCartId());
		shoppingCartImpl.setGroupId(shoppingCart.getGroupId());
		shoppingCartImpl.setCompanyId(shoppingCart.getCompanyId());
		shoppingCartImpl.setUserId(shoppingCart.getUserId());
		shoppingCartImpl.setUserName(shoppingCart.getUserName());
		shoppingCartImpl.setCreateDate(shoppingCart.getCreateDate());
		shoppingCartImpl.setModifiedDate(shoppingCart.getModifiedDate());
		shoppingCartImpl.setItemIds(shoppingCart.getItemIds());
		shoppingCartImpl.setCouponCodes(shoppingCart.getCouponCodes());
		shoppingCartImpl.setAltShipping(shoppingCart.getAltShipping());
		shoppingCartImpl.setInsure(shoppingCart.isInsure());

		return shoppingCartImpl;
	}

	/**
	 * Finds the shopping cart with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the shopping cart to find
	 * @return the shopping cart
	 * @throws com.liferay.portal.NoSuchModelException if a shopping cart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the shopping cart with the primary key or throws a {@link com.liferay.shopping.NoSuchCartException} if it could not be found.
	 *
	 * @param cartId the primary key of the shopping cart to find
	 * @return the shopping cart
	 * @throws com.liferay.shopping.NoSuchCartException if a shopping cart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart findByPrimaryKey(long cartId)
		throws NoSuchCartException, SystemException {
		ShoppingCart shoppingCart = fetchByPrimaryKey(cartId);

		if (shoppingCart == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + cartId);
			}

			throw new NoSuchCartException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				cartId);
		}

		return shoppingCart;
	}

	/**
	 * Finds the shopping cart with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the shopping cart to find
	 * @return the shopping cart, or <code>null</code> if a shopping cart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the shopping cart with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cartId the primary key of the shopping cart to find
	 * @return the shopping cart, or <code>null</code> if a shopping cart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart fetchByPrimaryKey(long cartId)
		throws SystemException {
		ShoppingCart shoppingCart = (ShoppingCart)EntityCacheUtil.getResult(ShoppingCartModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingCartImpl.class, cartId, this);

		if (shoppingCart == null) {
			Session session = null;

			try {
				session = openSession();

				shoppingCart = (ShoppingCart)session.get(ShoppingCartImpl.class,
						new Long(cartId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (shoppingCart != null) {
					cacheResult(shoppingCart);
				}

				closeSession(session);
			}
		}

		return shoppingCart;
	}

	/**
	 * Finds all the shopping carts where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching shopping carts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCart> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the shopping carts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of shopping carts to return
	 * @param end the upper bound of the range of shopping carts to return (not inclusive)
	 * @return the range of matching shopping carts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCart> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the shopping carts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of shopping carts to return
	 * @param end the upper bound of the range of shopping carts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching shopping carts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCart> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ShoppingCart> list = (List<ShoppingCart>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_SHOPPINGCART_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<ShoppingCart>)QueryUtil.list(q, getDialect(),
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
	 * Finds the first shopping cart in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching shopping cart
	 * @throws com.liferay.shopping.NoSuchCartException if a matching shopping cart could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCartException, SystemException {
		List<ShoppingCart> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCartException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last shopping cart in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching shopping cart
	 * @throws com.liferay.shopping.NoSuchCartException if a matching shopping cart could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCartException, SystemException {
		int count = countByGroupId(groupId);

		List<ShoppingCart> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCartException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the shopping carts before and after the current shopping cart in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cartId the primary key of the current shopping cart
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next shopping cart
	 * @throws com.liferay.shopping.NoSuchCartException if a shopping cart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart[] findByGroupId_PrevAndNext(long cartId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCartException, SystemException {
		ShoppingCart shoppingCart = findByPrimaryKey(cartId);

		Session session = null;

		try {
			session = openSession();

			ShoppingCart[] array = new ShoppingCartImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, shoppingCart, groupId,
					orderByComparator, true);

			array[1] = shoppingCart;

			array[2] = getByGroupId_PrevAndNext(session, shoppingCart, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingCart getByGroupId_PrevAndNext(Session session,
		ShoppingCart shoppingCart, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGCART_WHERE);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(shoppingCart);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingCart> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the shopping carts where userId = &#63;.
	 *
	 * @param userId the user id to search with
	 * @return the matching shopping carts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCart> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the shopping carts where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of shopping carts to return
	 * @param end the upper bound of the range of shopping carts to return (not inclusive)
	 * @return the range of matching shopping carts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCart> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the shopping carts where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of shopping carts to return
	 * @param end the upper bound of the range of shopping carts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching shopping carts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCart> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				userId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ShoppingCart> list = (List<ShoppingCart>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_SHOPPINGCART_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<ShoppingCart>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_USERID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first shopping cart in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching shopping cart
	 * @throws com.liferay.shopping.NoSuchCartException if a matching shopping cart could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCartException, SystemException {
		List<ShoppingCart> list = findByUserId(userId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCartException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last shopping cart in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching shopping cart
	 * @throws com.liferay.shopping.NoSuchCartException if a matching shopping cart could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCartException, SystemException {
		int count = countByUserId(userId);

		List<ShoppingCart> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCartException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the shopping carts before and after the current shopping cart in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cartId the primary key of the current shopping cart
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next shopping cart
	 * @throws com.liferay.shopping.NoSuchCartException if a shopping cart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart[] findByUserId_PrevAndNext(long cartId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCartException, SystemException {
		ShoppingCart shoppingCart = findByPrimaryKey(cartId);

		Session session = null;

		try {
			session = openSession();

			ShoppingCart[] array = new ShoppingCartImpl[3];

			array[0] = getByUserId_PrevAndNext(session, shoppingCart, userId,
					orderByComparator, true);

			array[1] = shoppingCart;

			array[2] = getByUserId_PrevAndNext(session, shoppingCart, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingCart getByUserId_PrevAndNext(Session session,
		ShoppingCart shoppingCart, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGCART_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(shoppingCart);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingCart> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the shopping cart where groupId = &#63; and userId = &#63; or throws a {@link com.liferay.shopping.NoSuchCartException} if it could not be found.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the matching shopping cart
	 * @throws com.liferay.shopping.NoSuchCartException if a matching shopping cart could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart findByG_U(long groupId, long userId)
		throws NoSuchCartException, SystemException {
		ShoppingCart shoppingCart = fetchByG_U(groupId, userId);

		if (shoppingCart == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCartException(msg.toString());
		}

		return shoppingCart;
	}

	/**
	 * Finds the shopping cart where groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the matching shopping cart, or <code>null</code> if a matching shopping cart could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart fetchByG_U(long groupId, long userId)
		throws SystemException {
		return fetchByG_U(groupId, userId, true);
	}

	/**
	 * Finds the shopping cart where groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the matching shopping cart, or <code>null</code> if a matching shopping cart could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCart fetchByG_U(long groupId, long userId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_U,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SHOPPINGCART_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				List<ShoppingCart> list = q.list();

				result = list;

				ShoppingCart shoppingCart = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_U,
						finderArgs, list);
				}
				else {
					shoppingCart = list.get(0);

					cacheResult(shoppingCart);

					if ((shoppingCart.getGroupId() != groupId) ||
							(shoppingCart.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_U,
							finderArgs, shoppingCart);
					}
				}

				return shoppingCart;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_U,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (ShoppingCart)result;
			}
		}
	}

	/**
	 * Finds all the shopping carts.
	 *
	 * @return the shopping carts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCart> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the shopping carts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of shopping carts to return
	 * @param end the upper bound of the range of shopping carts to return (not inclusive)
	 * @return the range of shopping carts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCart> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the shopping carts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of shopping carts to return
	 * @param end the upper bound of the range of shopping carts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of shopping carts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCart> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ShoppingCart> list = (List<ShoppingCart>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SHOPPINGCART);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHOPPINGCART;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ShoppingCart>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ShoppingCart>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the shopping carts where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (ShoppingCart shoppingCart : findByGroupId(groupId)) {
			remove(shoppingCart);
		}
	}

	/**
	 * Removes all the shopping carts where userId = &#63; from the database.
	 *
	 * @param userId the user id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (ShoppingCart shoppingCart : findByUserId(userId)) {
			remove(shoppingCart);
		}
	}

	/**
	 * Removes the shopping cart where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_U(long groupId, long userId)
		throws NoSuchCartException, SystemException {
		ShoppingCart shoppingCart = findByG_U(groupId, userId);

		remove(shoppingCart);
	}

	/**
	 * Removes all the shopping carts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ShoppingCart shoppingCart : findAll()) {
			remove(shoppingCart);
		}
	}

	/**
	 * Counts all the shopping carts where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching shopping carts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGCART_WHERE);

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
	 * Counts all the shopping carts where userId = &#63;.
	 *
	 * @param userId the user id to search with
	 * @return the number of matching shopping carts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGCART_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the shopping carts where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the number of matching shopping carts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_U(long groupId, long userId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_U,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHOPPINGCART_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_U, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the shopping carts.
	 *
	 * @return the number of shopping carts
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

				Query q = session.createQuery(_SQL_COUNT_SHOPPINGCART);

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
	 * Initializes the shopping cart persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.shopping.model.ShoppingCart")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ShoppingCart>> listenersList = new ArrayList<ModelListener<ShoppingCart>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ShoppingCart>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ShoppingCartImpl.class.getName());
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
	private static final String _SQL_SELECT_SHOPPINGCART = "SELECT shoppingCart FROM ShoppingCart shoppingCart";
	private static final String _SQL_SELECT_SHOPPINGCART_WHERE = "SELECT shoppingCart FROM ShoppingCart shoppingCart WHERE ";
	private static final String _SQL_COUNT_SHOPPINGCART = "SELECT COUNT(shoppingCart) FROM ShoppingCart shoppingCart";
	private static final String _SQL_COUNT_SHOPPINGCART_WHERE = "SELECT COUNT(shoppingCart) FROM ShoppingCart shoppingCart WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "shoppingCart.groupId = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "shoppingCart.userId = ?";
	private static final String _FINDER_COLUMN_G_U_GROUPID_2 = "shoppingCart.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_U_USERID_2 = "shoppingCart.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingCart.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingCart exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingCart exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ShoppingCartPersistenceImpl.class);
}