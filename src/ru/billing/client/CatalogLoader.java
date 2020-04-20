package ru.billing.client;
import ru.billing.stocklist.ItemCatalog;

public interface CatalogLoader {
    public void load(ItemCatalog cat); //загружает список товаров в указанный каталог (ru.billing.stocklist.ItemCatalog)

}
