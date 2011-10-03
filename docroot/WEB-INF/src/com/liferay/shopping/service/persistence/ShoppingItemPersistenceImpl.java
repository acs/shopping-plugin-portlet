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
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ImagePersistence;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.shopping.NoSuchItemException;
import com.liferay.shopping.model.ShoppingItem;
import com.liferay.shopping.model.impl.ShoppingItemImpl;
import com.liferay.shopping.model.impl.ShoppingItemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the shopping item service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ShoppingItemUtil} to access the shopping item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemPersistence
 * @see ShoppingItemUtil
 * @generated
 */
public class ShoppingItemPersistenceImpl extends BasePersistenceImpl<ShoppingItem>
	implements ShoppingItemPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ShoppingItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FETCH_BY_SMALLIMAGEID = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchBySmallImageId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_SMALLIMAGEID = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBySmallImageId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MEDIUMIMAGEID = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByMediumImageId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_MEDIUMIMAGEID = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByMediumImageId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_LARGEIMAGEID = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByLargeImageId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_LARGEIMAGEID = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByLargeImageId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_C = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_C",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_C_S = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_S",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_C_S = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByC_S",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the shopping item in the entity cache if it is enabled.
	 *
	 * @param shoppingItem the shopping item to cache
	 */
	public void cacheResult(ShoppingItem shoppingItem) {
		EntityCacheUtil.putResult(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemImpl.class, shoppingItem.getPrimaryKey(), shoppingItem);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SMALLIMAGEID,
			new Object[] { new Long(shoppingItem.getSmallImageId()) },
			shoppingItem);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MEDIUMIMAGEID,
			new Object[] { new Long(shoppingItem.getMediumImageId()) },
			shoppingItem);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LARGEIMAGEID,
			new Object[] { new Long(shoppingItem.getLargeImageId()) },
			shoppingItem);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_S,
			new Object[] {
				new Long(shoppingItem.getCompanyId()),
				
			shoppingItem.getSku()
			}, shoppingItem);
	}

	/**
	 * Caches the shopping items in the entity cache if it is enabled.
	 *
	 * @param shoppingItems the shopping items to cache
	 */
	public void cacheResult(List<ShoppingItem> shoppingItems) {
		for (ShoppingItem shoppingItem : shoppingItems) {
			if (EntityCacheUtil.getResult(
						ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingItemImpl.class, shoppingItem.getPrimaryKey(),
						this) == null) {
				cacheResult(shoppingItem);
			}
		}
	}

	/**
	 * Clears the cache for all shopping items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ShoppingItemImpl.class.getName());
		EntityCacheUtil.clearCache(ShoppingItemImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the shopping item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ShoppingItem shoppingItem) {
		EntityCacheUtil.removeResult(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemImpl.class, shoppingItem.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SMALLIMAGEID,
			new Object[] { new Long(shoppingItem.getSmallImageId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MEDIUMIMAGEID,
			new Object[] { new Long(shoppingItem.getMediumImageId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LARGEIMAGEID,
			new Object[] { new Long(shoppingItem.getLargeImageId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_S,
			new Object[] {
				new Long(shoppingItem.getCompanyId()),
				
			shoppingItem.getSku()
			});
	}

	/**
	 * Creates a new shopping item with the primary key. Does not add the shopping item to the database.
	 *
	 * @param itemId the primary key for the new shopping item
	 * @return the new shopping item
	 */
	public ShoppingItem create(long itemId) {
		ShoppingItem shoppingItem = new ShoppingItemImpl();

		shoppingItem.setNew(true);
		shoppingItem.setPrimaryKey(itemId);

		return shoppingItem;
	}

	/**
	 * Removes the shopping item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the shopping item to remove
	 * @return the shopping item that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a shopping item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the shopping item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemId the primary key of the shopping item to remove
	 * @return the shopping item that was removed
	 * @throws com.liferay.shopping.NoSuchItemException if a shopping item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem remove(long itemId)
		throws NoSuchItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ShoppingItem shoppingItem = (ShoppingItem)session.get(ShoppingItemImpl.class,
					new Long(itemId));

			if (shoppingItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + itemId);
				}

				throw new NoSuchItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					itemId);
			}

			return remove(shoppingItem);
		}
		catch (NoSuchItemException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingItem removeImpl(ShoppingItem shoppingItem)
		throws SystemException {
		shoppingItem = toUnwrappedModel(shoppingItem);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, shoppingItem);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		ShoppingItemModelImpl shoppingItemModelImpl = (ShoppingItemModelImpl)shoppingItem;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SMALLIMAGEID,
			new Object[] { new Long(shoppingItemModelImpl.getSmallImageId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MEDIUMIMAGEID,
			new Object[] { new Long(shoppingItemModelImpl.getMediumImageId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LARGEIMAGEID,
			new Object[] { new Long(shoppingItemModelImpl.getLargeImageId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_S,
			new Object[] {
				new Long(shoppingItemModelImpl.getCompanyId()),
				
			shoppingItemModelImpl.getSku()
			});

		EntityCacheUtil.removeResult(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemImpl.class, shoppingItem.getPrimaryKey());

		return shoppingItem;
	}

	public ShoppingItem updateImpl(
		com.liferay.shopping.model.ShoppingItem shoppingItem, boolean merge)
		throws SystemException {
		shoppingItem = toUnwrappedModel(shoppingItem);

		boolean isNew = shoppingItem.isNew();

		ShoppingItemModelImpl shoppingItemModelImpl = (ShoppingItemModelImpl)shoppingItem;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, shoppingItem, merge);

			shoppingItem.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingItemImpl.class, shoppingItem.getPrimaryKey(), shoppingItem);

		if (!isNew &&
				(shoppingItem.getSmallImageId() != shoppingItemModelImpl.getOriginalSmallImageId())) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SMALLIMAGEID,
				new Object[] {
					new Long(shoppingItemModelImpl.getOriginalSmallImageId())
				});
		}

		if (isNew ||
				(shoppingItem.getSmallImageId() != shoppingItemModelImpl.getOriginalSmallImageId())) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SMALLIMAGEID,
				new Object[] { new Long(shoppingItem.getSmallImageId()) },
				shoppingItem);
		}

		if (!isNew &&
				(shoppingItem.getMediumImageId() != shoppingItemModelImpl.getOriginalMediumImageId())) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MEDIUMIMAGEID,
				new Object[] {
					new Long(shoppingItemModelImpl.getOriginalMediumImageId())
				});
		}

		if (isNew ||
				(shoppingItem.getMediumImageId() != shoppingItemModelImpl.getOriginalMediumImageId())) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MEDIUMIMAGEID,
				new Object[] { new Long(shoppingItem.getMediumImageId()) },
				shoppingItem);
		}

		if (!isNew &&
				(shoppingItem.getLargeImageId() != shoppingItemModelImpl.getOriginalLargeImageId())) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LARGEIMAGEID,
				new Object[] {
					new Long(shoppingItemModelImpl.getOriginalLargeImageId())
				});
		}

		if (isNew ||
				(shoppingItem.getLargeImageId() != shoppingItemModelImpl.getOriginalLargeImageId())) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LARGEIMAGEID,
				new Object[] { new Long(shoppingItem.getLargeImageId()) },
				shoppingItem);
		}

		if (!isNew &&
				((shoppingItem.getCompanyId() != shoppingItemModelImpl.getOriginalCompanyId()) ||
				!Validator.equals(shoppingItem.getSku(),
					shoppingItemModelImpl.getOriginalSku()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_S,
				new Object[] {
					new Long(shoppingItemModelImpl.getOriginalCompanyId()),
					
				shoppingItemModelImpl.getOriginalSku()
				});
		}

		if (isNew ||
				((shoppingItem.getCompanyId() != shoppingItemModelImpl.getOriginalCompanyId()) ||
				!Validator.equals(shoppingItem.getSku(),
					shoppingItemModelImpl.getOriginalSku()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_S,
				new Object[] {
					new Long(shoppingItem.getCompanyId()),
					
				shoppingItem.getSku()
				}, shoppingItem);
		}

		return shoppingItem;
	}

	protected ShoppingItem toUnwrappedModel(ShoppingItem shoppingItem) {
		if (shoppingItem instanceof ShoppingItemImpl) {
			return shoppingItem;
		}

		ShoppingItemImpl shoppingItemImpl = new ShoppingItemImpl();

		shoppingItemImpl.setNew(shoppingItem.isNew());
		shoppingItemImpl.setPrimaryKey(shoppingItem.getPrimaryKey());

		shoppingItemImpl.setItemId(shoppingItem.getItemId());
		shoppingItemImpl.setGroupId(shoppingItem.getGroupId());
		shoppingItemImpl.setCompanyId(shoppingItem.getCompanyId());
		shoppingItemImpl.setUserId(shoppingItem.getUserId());
		shoppingItemImpl.setUserName(shoppingItem.getUserName());
		shoppingItemImpl.setCreateDate(shoppingItem.getCreateDate());
		shoppingItemImpl.setModifiedDate(shoppingItem.getModifiedDate());
		shoppingItemImpl.setCategoryId(shoppingItem.getCategoryId());
		shoppingItemImpl.setSku(shoppingItem.getSku());
		shoppingItemImpl.setName(shoppingItem.getName());
		shoppingItemImpl.setDescription(shoppingItem.getDescription());
		shoppingItemImpl.setProperties(shoppingItem.getProperties());
		shoppingItemImpl.setFields(shoppingItem.isFields());
		shoppingItemImpl.setFieldsQuantities(shoppingItem.getFieldsQuantities());
		shoppingItemImpl.setMinQuantity(shoppingItem.getMinQuantity());
		shoppingItemImpl.setMaxQuantity(shoppingItem.getMaxQuantity());
		shoppingItemImpl.setPrice(shoppingItem.getPrice());
		shoppingItemImpl.setDiscount(shoppingItem.getDiscount());
		shoppingItemImpl.setTaxable(shoppingItem.isTaxable());
		shoppingItemImpl.setShipping(shoppingItem.getShipping());
		shoppingItemImpl.setUseShippingFormula(shoppingItem.isUseShippingFormula());
		shoppingItemImpl.setRequiresShipping(shoppingItem.isRequiresShipping());
		shoppingItemImpl.setStockQuantity(shoppingItem.getStockQuantity());
		shoppingItemImpl.setFeatured(shoppingItem.isFeatured());
		shoppingItemImpl.setSale(shoppingItem.isSale());
		shoppingItemImpl.setSmallImage(shoppingItem.isSmallImage());
		shoppingItemImpl.setSmallImageId(shoppingItem.getSmallImageId());
		shoppingItemImpl.setSmallImageURL(shoppingItem.getSmallImageURL());
		shoppingItemImpl.setMediumImage(shoppingItem.isMediumImage());
		shoppingItemImpl.setMediumImageId(shoppingItem.getMediumImageId());
		shoppingItemImpl.setMediumImageURL(shoppingItem.getMediumImageURL());
		shoppingItemImpl.setLargeImage(shoppingItem.isLargeImage());
		shoppingItemImpl.setLargeImageId(shoppingItem.getLargeImageId());
		shoppingItemImpl.setLargeImageURL(shoppingItem.getLargeImageURL());

		return shoppingItemImpl;
	}

	/**
	 * Finds the shopping item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the shopping item to find
	 * @return the shopping item
	 * @throws com.liferay.portal.NoSuchModelException if a shopping item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the shopping item with the primary key or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	 *
	 * @param itemId the primary key of the shopping item to find
	 * @return the shopping item
	 * @throws com.liferay.shopping.NoSuchItemException if a shopping item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem findByPrimaryKey(long itemId)
		throws NoSuchItemException, SystemException {
		ShoppingItem shoppingItem = fetchByPrimaryKey(itemId);

		if (shoppingItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + itemId);
			}

			throw new NoSuchItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				itemId);
		}

		return shoppingItem;
	}

	/**
	 * Finds the shopping item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the shopping item to find
	 * @return the shopping item, or <code>null</code> if a shopping item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the shopping item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemId the primary key of the shopping item to find
	 * @return the shopping item, or <code>null</code> if a shopping item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem fetchByPrimaryKey(long itemId)
		throws SystemException {
		ShoppingItem shoppingItem = (ShoppingItem)EntityCacheUtil.getResult(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingItemImpl.class, itemId, this);

		if (shoppingItem == null) {
			Session session = null;

			try {
				session = openSession();

				shoppingItem = (ShoppingItem)session.get(ShoppingItemImpl.class,
						new Long(itemId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (shoppingItem != null) {
					cacheResult(shoppingItem);
				}

				closeSession(session);
			}
		}

		return shoppingItem;
	}

	/**
	 * Finds the shopping item where smallImageId = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	 *
	 * @param smallImageId the small image id to search with
	 * @return the matching shopping item
	 * @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem findBySmallImageId(long smallImageId)
		throws NoSuchItemException, SystemException {
		ShoppingItem shoppingItem = fetchBySmallImageId(smallImageId);

		if (shoppingItem == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("smallImageId=");
			msg.append(smallImageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchItemException(msg.toString());
		}

		return shoppingItem;
	}

	/**
	 * Finds the shopping item where smallImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param smallImageId the small image id to search with
	 * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem fetchBySmallImageId(long smallImageId)
		throws SystemException {
		return fetchBySmallImageId(smallImageId, true);
	}

	/**
	 * Finds the shopping item where smallImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param smallImageId the small image id to search with
	 * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem fetchBySmallImageId(long smallImageId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { smallImageId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SMALLIMAGEID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SHOPPINGITEM_WHERE);

			query.append(_FINDER_COLUMN_SMALLIMAGEID_SMALLIMAGEID_2);

			query.append(ShoppingItemModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(smallImageId);

				List<ShoppingItem> list = q.list();

				result = list;

				ShoppingItem shoppingItem = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SMALLIMAGEID,
						finderArgs, list);
				}
				else {
					shoppingItem = list.get(0);

					cacheResult(shoppingItem);

					if ((shoppingItem.getSmallImageId() != smallImageId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SMALLIMAGEID,
							finderArgs, shoppingItem);
					}
				}

				return shoppingItem;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SMALLIMAGEID,
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
				return (ShoppingItem)result;
			}
		}
	}

	/**
	 * Finds the shopping item where mediumImageId = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	 *
	 * @param mediumImageId the medium image id to search with
	 * @return the matching shopping item
	 * @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem findByMediumImageId(long mediumImageId)
		throws NoSuchItemException, SystemException {
		ShoppingItem shoppingItem = fetchByMediumImageId(mediumImageId);

		if (shoppingItem == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("mediumImageId=");
			msg.append(mediumImageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchItemException(msg.toString());
		}

		return shoppingItem;
	}

	/**
	 * Finds the shopping item where mediumImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mediumImageId the medium image id to search with
	 * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem fetchByMediumImageId(long mediumImageId)
		throws SystemException {
		return fetchByMediumImageId(mediumImageId, true);
	}

	/**
	 * Finds the shopping item where mediumImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mediumImageId the medium image id to search with
	 * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem fetchByMediumImageId(long mediumImageId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { mediumImageId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MEDIUMIMAGEID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SHOPPINGITEM_WHERE);

			query.append(_FINDER_COLUMN_MEDIUMIMAGEID_MEDIUMIMAGEID_2);

			query.append(ShoppingItemModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mediumImageId);

				List<ShoppingItem> list = q.list();

				result = list;

				ShoppingItem shoppingItem = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MEDIUMIMAGEID,
						finderArgs, list);
				}
				else {
					shoppingItem = list.get(0);

					cacheResult(shoppingItem);

					if ((shoppingItem.getMediumImageId() != mediumImageId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MEDIUMIMAGEID,
							finderArgs, shoppingItem);
					}
				}

				return shoppingItem;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MEDIUMIMAGEID,
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
				return (ShoppingItem)result;
			}
		}
	}

	/**
	 * Finds the shopping item where largeImageId = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	 *
	 * @param largeImageId the large image id to search with
	 * @return the matching shopping item
	 * @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem findByLargeImageId(long largeImageId)
		throws NoSuchItemException, SystemException {
		ShoppingItem shoppingItem = fetchByLargeImageId(largeImageId);

		if (shoppingItem == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("largeImageId=");
			msg.append(largeImageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchItemException(msg.toString());
		}

		return shoppingItem;
	}

	/**
	 * Finds the shopping item where largeImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param largeImageId the large image id to search with
	 * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem fetchByLargeImageId(long largeImageId)
		throws SystemException {
		return fetchByLargeImageId(largeImageId, true);
	}

	/**
	 * Finds the shopping item where largeImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param largeImageId the large image id to search with
	 * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem fetchByLargeImageId(long largeImageId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { largeImageId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LARGEIMAGEID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SHOPPINGITEM_WHERE);

			query.append(_FINDER_COLUMN_LARGEIMAGEID_LARGEIMAGEID_2);

			query.append(ShoppingItemModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(largeImageId);

				List<ShoppingItem> list = q.list();

				result = list;

				ShoppingItem shoppingItem = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LARGEIMAGEID,
						finderArgs, list);
				}
				else {
					shoppingItem = list.get(0);

					cacheResult(shoppingItem);

					if ((shoppingItem.getLargeImageId() != largeImageId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LARGEIMAGEID,
							finderArgs, shoppingItem);
					}
				}

				return shoppingItem;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LARGEIMAGEID,
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
				return (ShoppingItem)result;
			}
		}
	}

	/**
	 * Finds all the shopping items where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param categoryId the category id to search with
	 * @return the matching shopping items
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItem> findByG_C(long groupId, long categoryId)
		throws SystemException {
		return findByG_C(groupId, categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the shopping items where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param categoryId the category id to search with
	 * @param start the lower bound of the range of shopping items to return
	 * @param end the upper bound of the range of shopping items to return (not inclusive)
	 * @return the range of matching shopping items
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItem> findByG_C(long groupId, long categoryId,
		int start, int end) throws SystemException {
		return findByG_C(groupId, categoryId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the shopping items where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param categoryId the category id to search with
	 * @param start the lower bound of the range of shopping items to return
	 * @param end the upper bound of the range of shopping items to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching shopping items
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItem> findByG_C(long groupId, long categoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, categoryId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ShoppingItem> list = (List<ShoppingItem>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_C,
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

			query.append(_SQL_SELECT_SHOPPINGITEM_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ShoppingItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				list = (List<ShoppingItem>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_C,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_C,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first shopping item in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param categoryId the category id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching shopping item
	 * @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem findByG_C_First(long groupId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		List<ShoppingItem> list = findByG_C(groupId, categoryId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", categoryId=");
			msg.append(categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchItemException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last shopping item in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param categoryId the category id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching shopping item
	 * @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem findByG_C_Last(long groupId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		int count = countByG_C(groupId, categoryId);

		List<ShoppingItem> list = findByG_C(groupId, categoryId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", categoryId=");
			msg.append(categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchItemException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the shopping items before and after the current shopping item in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param itemId the primary key of the current shopping item
	 * @param groupId the group id to search with
	 * @param categoryId the category id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next shopping item
	 * @throws com.liferay.shopping.NoSuchItemException if a shopping item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem[] findByG_C_PrevAndNext(long itemId, long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		ShoppingItem shoppingItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			ShoppingItem[] array = new ShoppingItemImpl[3];

			array[0] = getByG_C_PrevAndNext(session, shoppingItem, groupId,
					categoryId, orderByComparator, true);

			array[1] = shoppingItem;

			array[2] = getByG_C_PrevAndNext(session, shoppingItem, groupId,
					categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingItem getByG_C_PrevAndNext(Session session,
		ShoppingItem shoppingItem, long groupId, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGITEM_WHERE);

		query.append(_FINDER_COLUMN_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

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
			query.append(ShoppingItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(shoppingItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the shopping item where companyId = &#63; and sku = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	 *
	 * @param companyId the company id to search with
	 * @param sku the sku to search with
	 * @return the matching shopping item
	 * @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem findByC_S(long companyId, String sku)
		throws NoSuchItemException, SystemException {
		ShoppingItem shoppingItem = fetchByC_S(companyId, sku);

		if (shoppingItem == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", sku=");
			msg.append(sku);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchItemException(msg.toString());
		}

		return shoppingItem;
	}

	/**
	 * Finds the shopping item where companyId = &#63; and sku = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company id to search with
	 * @param sku the sku to search with
	 * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem fetchByC_S(long companyId, String sku)
		throws SystemException {
		return fetchByC_S(companyId, sku, true);
	}

	/**
	 * Finds the shopping item where companyId = &#63; and sku = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company id to search with
	 * @param sku the sku to search with
	 * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingItem fetchByC_S(long companyId, String sku,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, sku };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_S,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SHOPPINGITEM_WHERE);

			query.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			if (sku == null) {
				query.append(_FINDER_COLUMN_C_S_SKU_1);
			}
			else {
				if (sku.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_S_SKU_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_S_SKU_2);
				}
			}

			query.append(ShoppingItemModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (sku != null) {
					qPos.add(sku);
				}

				List<ShoppingItem> list = q.list();

				result = list;

				ShoppingItem shoppingItem = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_S,
						finderArgs, list);
				}
				else {
					shoppingItem = list.get(0);

					cacheResult(shoppingItem);

					if ((shoppingItem.getCompanyId() != companyId) ||
							(shoppingItem.getSku() == null) ||
							!shoppingItem.getSku().equals(sku)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_S,
							finderArgs, shoppingItem);
					}
				}

				return shoppingItem;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_S,
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
				return (ShoppingItem)result;
			}
		}
	}

	/**
	 * Finds all the shopping items.
	 *
	 * @return the shopping items
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the shopping items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of shopping items to return
	 * @param end the upper bound of the range of shopping items to return (not inclusive)
	 * @return the range of shopping items
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the shopping items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of shopping items to return
	 * @param end the upper bound of the range of shopping items to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of shopping items
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingItem> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ShoppingItem> list = (List<ShoppingItem>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SHOPPINGITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHOPPINGITEM.concat(ShoppingItemModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ShoppingItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ShoppingItem>)QueryUtil.list(q, getDialect(),
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
	 * Removes the shopping item where smallImageId = &#63; from the database.
	 *
	 * @param smallImageId the small image id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBySmallImageId(long smallImageId)
		throws NoSuchItemException, SystemException {
		ShoppingItem shoppingItem = findBySmallImageId(smallImageId);

		remove(shoppingItem);
	}

	/**
	 * Removes the shopping item where mediumImageId = &#63; from the database.
	 *
	 * @param mediumImageId the medium image id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMediumImageId(long mediumImageId)
		throws NoSuchItemException, SystemException {
		ShoppingItem shoppingItem = findByMediumImageId(mediumImageId);

		remove(shoppingItem);
	}

	/**
	 * Removes the shopping item where largeImageId = &#63; from the database.
	 *
	 * @param largeImageId the large image id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLargeImageId(long largeImageId)
		throws NoSuchItemException, SystemException {
		ShoppingItem shoppingItem = findByLargeImageId(largeImageId);

		remove(shoppingItem);
	}

	/**
	 * Removes all the shopping items where groupId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param categoryId the category id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_C(long groupId, long categoryId)
		throws SystemException {
		for (ShoppingItem shoppingItem : findByG_C(groupId, categoryId)) {
			remove(shoppingItem);
		}
	}

	/**
	 * Removes the shopping item where companyId = &#63; and sku = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @param sku the sku to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_S(long companyId, String sku)
		throws NoSuchItemException, SystemException {
		ShoppingItem shoppingItem = findByC_S(companyId, sku);

		remove(shoppingItem);
	}

	/**
	 * Removes all the shopping items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ShoppingItem shoppingItem : findAll()) {
			remove(shoppingItem);
		}
	}

	/**
	 * Counts all the shopping items where smallImageId = &#63;.
	 *
	 * @param smallImageId the small image id to search with
	 * @return the number of matching shopping items
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySmallImageId(long smallImageId) throws SystemException {
		Object[] finderArgs = new Object[] { smallImageId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SMALLIMAGEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGITEM_WHERE);

			query.append(_FINDER_COLUMN_SMALLIMAGEID_SMALLIMAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(smallImageId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SMALLIMAGEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the shopping items where mediumImageId = &#63;.
	 *
	 * @param mediumImageId the medium image id to search with
	 * @return the number of matching shopping items
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMediumImageId(long mediumImageId)
		throws SystemException {
		Object[] finderArgs = new Object[] { mediumImageId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MEDIUMIMAGEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGITEM_WHERE);

			query.append(_FINDER_COLUMN_MEDIUMIMAGEID_MEDIUMIMAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mediumImageId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MEDIUMIMAGEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the shopping items where largeImageId = &#63;.
	 *
	 * @param largeImageId the large image id to search with
	 * @return the number of matching shopping items
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLargeImageId(long largeImageId) throws SystemException {
		Object[] finderArgs = new Object[] { largeImageId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LARGEIMAGEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGITEM_WHERE);

			query.append(_FINDER_COLUMN_LARGEIMAGEID_LARGEIMAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(largeImageId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LARGEIMAGEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the shopping items where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param categoryId the category id to search with
	 * @return the number of matching shopping items
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_C(long groupId, long categoryId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, categoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_C,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHOPPINGITEM_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_C, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the shopping items where companyId = &#63; and sku = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param sku the sku to search with
	 * @return the number of matching shopping items
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_S(long companyId, String sku) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, sku };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_S,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHOPPINGITEM_WHERE);

			query.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			if (sku == null) {
				query.append(_FINDER_COLUMN_C_S_SKU_1);
			}
			else {
				if (sku.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_S_SKU_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_S_SKU_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (sku != null) {
					qPos.add(sku);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_S, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the shopping items.
	 *
	 * @return the number of shopping items
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

				Query q = session.createQuery(_SQL_COUNT_SHOPPINGITEM);

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
	 * Gets all the shopping item prices associated with the shopping item.
	 *
	 * @param pk the primary key of the shopping item to get the associated shopping item prices for
	 * @return the shopping item prices associated with the shopping item
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.liferay.shopping.model.ShoppingItemPrice> getShoppingItemPrices(
		long pk) throws SystemException {
		return getShoppingItemPrices(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Gets a range of all the shopping item prices associated with the shopping item.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the shopping item to get the associated shopping item prices for
	 * @param start the lower bound of the range of shopping items to return
	 * @param end the upper bound of the range of shopping items to return (not inclusive)
	 * @return the range of shopping item prices associated with the shopping item
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.liferay.shopping.model.ShoppingItemPrice> getShoppingItemPrices(
		long pk, int start, int end) throws SystemException {
		return getShoppingItemPrices(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_SHOPPINGITEMPRICES = new FinderPath(com.liferay.shopping.model.impl.ShoppingItemPriceModelImpl.ENTITY_CACHE_ENABLED,
			com.liferay.shopping.model.impl.ShoppingItemPriceModelImpl.FINDER_CACHE_ENABLED,
			com.liferay.shopping.service.persistence.ShoppingItemPricePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getShoppingItemPrices",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	/**
	 * Gets an ordered range of all the shopping item prices associated with the shopping item.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the shopping item to get the associated shopping item prices for
	 * @param start the lower bound of the range of shopping items to return
	 * @param end the upper bound of the range of shopping items to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of shopping item prices associated with the shopping item
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.liferay.shopping.model.ShoppingItemPrice> getShoppingItemPrices(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<com.liferay.shopping.model.ShoppingItemPrice> list = (List<com.liferay.shopping.model.ShoppingItemPrice>)FinderCacheUtil.getResult(FINDER_PATH_GET_SHOPPINGITEMPRICES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETSHOPPINGITEMPRICES.concat(ORDER_BY_CLAUSE)
													.concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETSHOPPINGITEMPRICES.concat(com.liferay.shopping.model.impl.ShoppingItemPriceModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("Shopping_ShoppingItemPrice",
					com.liferay.shopping.model.impl.ShoppingItemPriceImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<com.liferay.shopping.model.ShoppingItemPrice>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_SHOPPINGITEMPRICES,
						finderArgs);
				}
				else {
					shoppingItemPricePersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_SHOPPINGITEMPRICES,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_SHOPPINGITEMPRICES_SIZE = new FinderPath(com.liferay.shopping.model.impl.ShoppingItemPriceModelImpl.ENTITY_CACHE_ENABLED,
			com.liferay.shopping.model.impl.ShoppingItemPriceModelImpl.FINDER_CACHE_ENABLED,
			com.liferay.shopping.service.persistence.ShoppingItemPricePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getShoppingItemPricesSize", new String[] { Long.class.getName() });

	/**
	 * Gets the number of shopping item prices associated with the shopping item.
	 *
	 * @param pk the primary key of the shopping item to get the number of associated shopping item prices for
	 * @return the number of shopping item prices associated with the shopping item
	 * @throws SystemException if a system exception occurred
	 */
	public int getShoppingItemPricesSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_SHOPPINGITEMPRICES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETSHOPPINGITEMPRICESSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_SHOPPINGITEMPRICES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_SHOPPINGITEMPRICE = new FinderPath(com.liferay.shopping.model.impl.ShoppingItemPriceModelImpl.ENTITY_CACHE_ENABLED,
			com.liferay.shopping.model.impl.ShoppingItemPriceModelImpl.FINDER_CACHE_ENABLED,
			com.liferay.shopping.service.persistence.ShoppingItemPricePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsShoppingItemPrice",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Determines if the shopping item price is associated with the shopping item.
	 *
	 * @param pk the primary key of the shopping item
	 * @param shoppingItemPricePK the primary key of the shopping item price
	 * @return <code>true</code> if the shopping item price is associated with the shopping item; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsShoppingItemPrice(long pk, long shoppingItemPricePK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, shoppingItemPricePK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_SHOPPINGITEMPRICE,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsShoppingItemPrice.contains(pk,
							shoppingItemPricePK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_SHOPPINGITEMPRICE,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Determines if the shopping item has any shopping item prices associated with it.
	 *
	 * @param pk the primary key of the shopping item to check for associations with shopping item prices
	 * @return <code>true</code> if the shopping item has any shopping item prices associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsShoppingItemPrices(long pk)
		throws SystemException {
		if (getShoppingItemPricesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the shopping item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.shopping.model.ShoppingItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ShoppingItem>> listenersList = new ArrayList<ModelListener<ShoppingItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ShoppingItem>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsShoppingItemPrice = new ContainsShoppingItemPrice(this);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ShoppingItemImpl.class.getName());
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
	@BeanReference(type = ImagePersistence.class)
	protected ImagePersistence imagePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	protected ContainsShoppingItemPrice containsShoppingItemPrice;

	protected class ContainsShoppingItemPrice {
		protected ContainsShoppingItemPrice(
			ShoppingItemPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSSHOPPINGITEMPRICE,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long itemId, long itemPriceId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(itemId), new Long(itemPriceId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_SHOPPINGITEM = "SELECT shoppingItem FROM ShoppingItem shoppingItem";
	private static final String _SQL_SELECT_SHOPPINGITEM_WHERE = "SELECT shoppingItem FROM ShoppingItem shoppingItem WHERE ";
	private static final String _SQL_COUNT_SHOPPINGITEM = "SELECT COUNT(shoppingItem) FROM ShoppingItem shoppingItem";
	private static final String _SQL_COUNT_SHOPPINGITEM_WHERE = "SELECT COUNT(shoppingItem) FROM ShoppingItem shoppingItem WHERE ";
	private static final String _SQL_GETSHOPPINGITEMPRICES = "SELECT {Shopping_ShoppingItemPrice.*} FROM Shopping_ShoppingItemPrice INNER JOIN Shopping_ShoppingItem ON (Shopping_ShoppingItem.itemId = Shopping_ShoppingItemPrice.itemId) WHERE (Shopping_ShoppingItem.itemId = ?)";
	private static final String _SQL_GETSHOPPINGITEMPRICESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM Shopping_ShoppingItemPrice WHERE itemId = ?";
	private static final String _SQL_CONTAINSSHOPPINGITEMPRICE = "SELECT COUNT(*) AS COUNT_VALUE FROM Shopping_ShoppingItemPrice WHERE itemId = ? AND itemPriceId = ?";
	private static final String _FINDER_COLUMN_SMALLIMAGEID_SMALLIMAGEID_2 = "shoppingItem.smallImageId = ?";
	private static final String _FINDER_COLUMN_MEDIUMIMAGEID_MEDIUMIMAGEID_2 = "shoppingItem.mediumImageId = ?";
	private static final String _FINDER_COLUMN_LARGEIMAGEID_LARGEIMAGEID_2 = "shoppingItem.largeImageId = ?";
	private static final String _FINDER_COLUMN_G_C_GROUPID_2 = "shoppingItem.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_CATEGORYID_2 = "shoppingItem.categoryId = ?";
	private static final String _FINDER_COLUMN_C_S_COMPANYID_2 = "shoppingItem.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_S_SKU_1 = "shoppingItem.sku IS NULL";
	private static final String _FINDER_COLUMN_C_S_SKU_2 = "shoppingItem.sku = ?";
	private static final String _FINDER_COLUMN_C_S_SKU_3 = "(shoppingItem.sku IS NULL OR shoppingItem.sku = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingItem exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ShoppingItemPersistenceImpl.class);
}