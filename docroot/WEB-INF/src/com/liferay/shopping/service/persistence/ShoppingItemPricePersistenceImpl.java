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

import com.liferay.shopping.NoSuchItemPriceException;
import com.liferay.shopping.model.ShoppingItemPrice;
import com.liferay.shopping.model.impl.ShoppingItemPriceImpl;
import com.liferay.shopping.model.impl.ShoppingItemPriceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the shopping item price service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemPricePersistence
 * @see ShoppingItemPriceUtil
 * @generated
 */
public class ShoppingItemPricePersistenceImpl extends BasePersistenceImpl<ShoppingItemPrice>
	implements ShoppingItemPricePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ShoppingItemPriceUtil} to access the shopping item price persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ShoppingItemPriceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ITEMID = new FinderPath(ShoppingItemPriceModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemPriceModelImpl.FINDER_CACHE_ENABLED,
			ShoppingItemPriceImpl.class, FINDER_CLASS_NAME_LIST,
			"findByItemId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMID = new FinderPath(ShoppingItemPriceModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemPriceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByItemId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ShoppingItemPriceModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemPriceModelImpl.FINDER_CACHE_ENABLED,
			ShoppingItemPriceImpl.class, FINDER_CLASS_NAME_LIST, "findAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingItemPriceModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemPriceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the shopping item price in the entity cache if it is enabled.
	 *
	 * @param shoppingItemPrice the shopping item price
	 */
	public void cacheResult(ShoppingItemPrice shoppingItemPrice) {
		EntityCacheUtil.putResult(ShoppingItemPriceModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemPriceImpl.class, shoppingItemPrice.getPrimaryKey(),
			shoppingItemPrice);

		shoppingItemPrice.resetOriginalValues();
	}

	/**
	 * Caches the shopping item prices in the entity cache if it is enabled.
	 *
	 * @param shoppingItemPrices the shopping item prices
	 */
	public void cacheResult(List<ShoppingItemPrice> shoppingItemPrices) {
		for (ShoppingItemPrice shoppingItemPrice : shoppingItemPrices) {
			if (EntityCacheUtil.getResult(
						ShoppingItemPriceModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingItemPriceImpl.class,
						shoppingItemPrice.getPrimaryKey()) == null) {
				cacheResult(shoppingItemPrice);
			}
		}
	}

	/**
	 * Clears the cache for all shopping item prices.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ShoppingItemPriceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ShoppingItemPriceImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the shopping item price.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ShoppingItemPrice shoppingItemPrice) {
		EntityCacheUtil.removeResult(ShoppingItemPriceModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemPriceImpl.class, shoppingItemPrice.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL, FINDER_ARGS_EMPTY);
	}

	/**
	 * Creates a new shopping item price with the primary key. Does not add the shopping item price to the database.
	 *
	 * @param itemPriceId the primary key for the new shopping item price
	 * @return the new shopping item price
	 */
	public ShoppingItemPrice create(long itemPriceId) {
		ShoppingItemPrice shoppingItemPrice = new ShoppingItemPriceImpl();

		shoppingItemPrice.setNew(true);
		shoppingItemPrice.setPrimaryKey(itemPriceId);

		return shoppingItemPrice;
	}

	/**
	 * Removes the shopping item price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the shopping item price
	 * @return the shopping item price that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a shopping item price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingItemPrice remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the shopping item price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemPriceId the primary key of the shopping item price
	 * @return the shopping item price that was removed
	 * @throws com.liferay.shopping.NoSuchItemPriceException if a shopping item price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemPrice remove(long itemPriceId)
		throws NoSuchItemPriceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ShoppingItemPrice shoppingItemPrice = (ShoppingItemPrice)session.get(ShoppingItemPriceImpl.class,
					Long.valueOf(itemPriceId));

			if (shoppingItemPrice == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + itemPriceId);
				}

				throw new NoSuchItemPriceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					itemPriceId);
			}

			return shoppingItemPricePersistence.remove(shoppingItemPrice);
		}
		catch (NoSuchItemPriceException nsee) {
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
	 * Removes the shopping item price from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shoppingItemPrice the shopping item price
	 * @return the shopping item price that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingItemPrice remove(ShoppingItemPrice shoppingItemPrice)
		throws SystemException {
		return super.remove(shoppingItemPrice);
	}

	@Override
	protected ShoppingItemPrice removeImpl(ShoppingItemPrice shoppingItemPrice)
		throws SystemException {
		shoppingItemPrice = toUnwrappedModel(shoppingItemPrice);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, shoppingItemPrice);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ShoppingItemPriceModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemPriceImpl.class, shoppingItemPrice.getPrimaryKey());

		return shoppingItemPrice;
	}

	@Override
	public ShoppingItemPrice updateImpl(
		com.liferay.shopping.model.ShoppingItemPrice shoppingItemPrice,
		boolean merge) throws SystemException {
		shoppingItemPrice = toUnwrappedModel(shoppingItemPrice);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, shoppingItemPrice, merge);

			shoppingItemPrice.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ShoppingItemPriceModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemPriceImpl.class, shoppingItemPrice.getPrimaryKey(),
			shoppingItemPrice);

		return shoppingItemPrice;
	}

	protected ShoppingItemPrice toUnwrappedModel(
		ShoppingItemPrice shoppingItemPrice) {
		if (shoppingItemPrice instanceof ShoppingItemPriceImpl) {
			return shoppingItemPrice;
		}

		ShoppingItemPriceImpl shoppingItemPriceImpl = new ShoppingItemPriceImpl();

		shoppingItemPriceImpl.setNew(shoppingItemPrice.isNew());
		shoppingItemPriceImpl.setPrimaryKey(shoppingItemPrice.getPrimaryKey());

		shoppingItemPriceImpl.setItemPriceId(shoppingItemPrice.getItemPriceId());
		shoppingItemPriceImpl.setItemId(shoppingItemPrice.getItemId());
		shoppingItemPriceImpl.setMinQuantity(shoppingItemPrice.getMinQuantity());
		shoppingItemPriceImpl.setMaxQuantity(shoppingItemPrice.getMaxQuantity());
		shoppingItemPriceImpl.setPrice(shoppingItemPrice.getPrice());
		shoppingItemPriceImpl.setDiscount(shoppingItemPrice.getDiscount());
		shoppingItemPriceImpl.setTaxable(shoppingItemPrice.isTaxable());
		shoppingItemPriceImpl.setShipping(shoppingItemPrice.getShipping());
		shoppingItemPriceImpl.setUseShippingFormula(shoppingItemPrice.isUseShippingFormula());
		shoppingItemPriceImpl.setStatus(shoppingItemPrice.getStatus());

		return shoppingItemPriceImpl;
	}

	/**
	 * Returns the shopping item price with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the shopping item price
	 * @return the shopping item price
	 * @throws com.liferay.portal.NoSuchModelException if a shopping item price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingItemPrice findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the shopping item price with the primary key or throws a {@link com.liferay.shopping.NoSuchItemPriceException} if it could not be found.
	 *
	 * @param itemPriceId the primary key of the shopping item price
	 * @return the shopping item price
	 * @throws com.liferay.shopping.NoSuchItemPriceException if a shopping item price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemPrice findByPrimaryKey(long itemPriceId)
		throws NoSuchItemPriceException, SystemException {
		ShoppingItemPrice shoppingItemPrice = fetchByPrimaryKey(itemPriceId);

		if (shoppingItemPrice == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + itemPriceId);
			}

			throw new NoSuchItemPriceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				itemPriceId);
		}

		return shoppingItemPrice;
	}

	/**
	 * Returns the shopping item price with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the shopping item price
	 * @return the shopping item price, or <code>null</code> if a shopping item price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingItemPrice fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the shopping item price with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemPriceId the primary key of the shopping item price
	 * @return the shopping item price, or <code>null</code> if a shopping item price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemPrice fetchByPrimaryKey(long itemPriceId)
		throws SystemException {
		ShoppingItemPrice shoppingItemPrice = (ShoppingItemPrice)EntityCacheUtil.getResult(ShoppingItemPriceModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingItemPriceImpl.class, itemPriceId);

		if (shoppingItemPrice == _nullShoppingItemPrice) {
			return null;
		}

		if (shoppingItemPrice == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				shoppingItemPrice = (ShoppingItemPrice)session.get(ShoppingItemPriceImpl.class,
						Long.valueOf(itemPriceId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (shoppingItemPrice != null) {
					cacheResult(shoppingItemPrice);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ShoppingItemPriceModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingItemPriceImpl.class, itemPriceId,
						_nullShoppingItemPrice);
				}

				closeSession(session);
			}
		}

		return shoppingItemPrice;
	}

	/**
	 * Returns all the shopping item prices where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the matching shopping item prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItemPrice> findByItemId(long itemId)
		throws SystemException {
		return findByItemId(itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the shopping item prices where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of shopping item prices
	 * @param end the upper bound of the range of shopping item prices (not inclusive)
	 * @return the range of matching shopping item prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItemPrice> findByItemId(long itemId, int start, int end)
		throws SystemException {
		return findByItemId(itemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the shopping item prices where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of shopping item prices
	 * @param end the upper bound of the range of shopping item prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shopping item prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItemPrice> findByItemId(long itemId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { itemId, start, end, orderByComparator };

		List<ShoppingItemPrice> list = (List<ShoppingItemPrice>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ITEMID,
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

			query.append(_SQL_SELECT_SHOPPINGITEMPRICE_WHERE);

			query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ShoppingItemPriceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

				list = (List<ShoppingItemPrice>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first shopping item price in the ordered set where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shopping item price
	 * @throws com.liferay.shopping.NoSuchItemPriceException if a matching shopping item price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemPrice findByItemId_First(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchItemPriceException, SystemException {
		List<ShoppingItemPrice> list = findByItemId(itemId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("itemId=");
			msg.append(itemId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchItemPriceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last shopping item price in the ordered set where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shopping item price
	 * @throws com.liferay.shopping.NoSuchItemPriceException if a matching shopping item price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemPrice findByItemId_Last(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchItemPriceException, SystemException {
		int count = countByItemId(itemId);

		List<ShoppingItemPrice> list = findByItemId(itemId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("itemId=");
			msg.append(itemId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchItemPriceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the shopping item prices before and after the current shopping item price in the ordered set where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param itemPriceId the primary key of the current shopping item price
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shopping item price
	 * @throws com.liferay.shopping.NoSuchItemPriceException if a shopping item price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItemPrice[] findByItemId_PrevAndNext(long itemPriceId,
		long itemId, OrderByComparator orderByComparator)
		throws NoSuchItemPriceException, SystemException {
		ShoppingItemPrice shoppingItemPrice = findByPrimaryKey(itemPriceId);

		Session session = null;

		try {
			session = openSession();

			ShoppingItemPrice[] array = new ShoppingItemPriceImpl[3];

			array[0] = getByItemId_PrevAndNext(session, shoppingItemPrice,
					itemId, orderByComparator, true);

			array[1] = shoppingItemPrice;

			array[2] = getByItemId_PrevAndNext(session, shoppingItemPrice,
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

	protected ShoppingItemPrice getByItemId_PrevAndNext(Session session,
		ShoppingItemPrice shoppingItemPrice, long itemId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGITEMPRICE_WHERE);

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
			query.append(ShoppingItemPriceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(itemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(shoppingItemPrice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingItemPrice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the shopping item prices.
	 *
	 * @return the shopping item prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItemPrice> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the shopping item prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of shopping item prices
	 * @param end the upper bound of the range of shopping item prices (not inclusive)
	 * @return the range of shopping item prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItemPrice> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the shopping item prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of shopping item prices
	 * @param end the upper bound of the range of shopping item prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of shopping item prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItemPrice> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		List<ShoppingItemPrice> list = (List<ShoppingItemPrice>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SHOPPINGITEMPRICE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHOPPINGITEMPRICE.concat(ShoppingItemPriceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ShoppingItemPrice>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ShoppingItemPrice>)QueryUtil.list(q,
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
	 * Removes all the shopping item prices where itemId = &#63; from the database.
	 *
	 * @param itemId the item ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByItemId(long itemId) throws SystemException {
		for (ShoppingItemPrice shoppingItemPrice : findByItemId(itemId)) {
			shoppingItemPricePersistence.remove(shoppingItemPrice);
		}
	}

	/**
	 * Removes all the shopping item prices from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ShoppingItemPrice shoppingItemPrice : findAll()) {
			shoppingItemPricePersistence.remove(shoppingItemPrice);
		}
	}

	/**
	 * Returns the number of shopping item prices where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the number of matching shopping item prices
	 * @throws SystemException if a system exception occurred
	 */
	public int countByItemId(long itemId) throws SystemException {
		Object[] finderArgs = new Object[] { itemId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ITEMID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGITEMPRICE_WHERE);

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
	 * Returns the number of shopping item prices.
	 *
	 * @return the number of shopping item prices
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SHOPPINGITEMPRICE);

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
	 * Initializes the shopping item price persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.shopping.model.ShoppingItemPrice")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ShoppingItemPrice>> listenersList = new ArrayList<ModelListener<ShoppingItemPrice>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ShoppingItemPrice>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ShoppingItemPriceImpl.class.getName());
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
	private static final String _SQL_SELECT_SHOPPINGITEMPRICE = "SELECT shoppingItemPrice FROM ShoppingItemPrice shoppingItemPrice";
	private static final String _SQL_SELECT_SHOPPINGITEMPRICE_WHERE = "SELECT shoppingItemPrice FROM ShoppingItemPrice shoppingItemPrice WHERE ";
	private static final String _SQL_COUNT_SHOPPINGITEMPRICE = "SELECT COUNT(shoppingItemPrice) FROM ShoppingItemPrice shoppingItemPrice";
	private static final String _SQL_COUNT_SHOPPINGITEMPRICE_WHERE = "SELECT COUNT(shoppingItemPrice) FROM ShoppingItemPrice shoppingItemPrice WHERE ";
	private static final String _FINDER_COLUMN_ITEMID_ITEMID_2 = "shoppingItemPrice.itemId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingItemPrice.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingItemPrice exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingItemPrice exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ShoppingItemPricePersistenceImpl.class);
	private static ShoppingItemPrice _nullShoppingItemPrice = new ShoppingItemPriceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ShoppingItemPrice> toCacheModel() {
				return _nullShoppingItemPriceCacheModel;
			}
		};

	private static CacheModel<ShoppingItemPrice> _nullShoppingItemPriceCacheModel =
		new CacheModel<ShoppingItemPrice>() {
			public ShoppingItemPrice toEntityModel() {
				return _nullShoppingItemPrice;
			}
		};
}