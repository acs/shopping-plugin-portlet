create index IX_23AB8425 on Shopping_ShoppingCart (groupId);
create unique index IX_2988E75F on Shopping_ShoppingCart (groupId, userId);
create index IX_3629ED5F on Shopping_ShoppingCart (userId);

create index IX_D6955307 on Shopping_ShoppingCategory (groupId);
create index IX_D92BDA7E on Shopping_ShoppingCategory (groupId, parentCategoryId);

create unique index IX_3D8111F7 on Shopping_ShoppingCoupon (code_);
create index IX_CC6A831F on Shopping_ShoppingCoupon (groupId);

create unique index IX_E418C63D on Shopping_ShoppingItem (companyId, sku);
create index IX_7B289A3F on Shopping_ShoppingItem (groupId, categoryId);
create index IX_FF888AA7 on Shopping_ShoppingItem (largeImageId);
create index IX_4C2552B9 on Shopping_ShoppingItem (mediumImageId);
create index IX_6E6AF65B on Shopping_ShoppingItem (smallImageId);

create index IX_E4939150 on Shopping_ShoppingItemField (itemId);

create index IX_61A3CADF on Shopping_ShoppingItemPrice (itemId);

create index IX_DFFD5C15 on Shopping_ShoppingOrder (groupId);
create index IX_892ADF39 on Shopping_ShoppingOrder (groupId, userId, ppPaymentStatus);
create unique index IX_9ABEEF51 on Shopping_ShoppingOrder (number_);
create index IX_B75D0460 on Shopping_ShoppingOrder (ppTxnId);

create index IX_2542EFD1 on Shopping_ShoppingOrderItem (orderId);