Liferay.Service.register("Liferay.Service.Shopping", "com.liferay.shopping.service", "shopping-plugin-portlet");

Liferay.Service.registerClass(
	Liferay.Service.Shopping, "ShoppingCategory",
	{
		addCategory: true,
		deleteCategory: true,
		getCategories: true,
		getCategoriesCount: true,
		getCategory: true,
		getSubcategoryIds: true,
		updateCategory: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.Shopping, "ShoppingCoupon",
	{
		addCoupon: true,
		deleteCoupon: true,
		getCoupon: true,
		search: true,
		updateCoupon: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.Shopping, "ShoppingItem",
	{
		deleteItem: true,
		getCategoriesItemsCount: true,
		getItem: true,
		getItems: true,
		getItemsCount: true,
		getItemsPrevAndNext: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.Shopping, "ShoppingOrder",
	{
		completeOrder: true,
		deleteOrder: true,
		getOrder: true,
		sendEmail: true,
		updateOrder: true
	}
);