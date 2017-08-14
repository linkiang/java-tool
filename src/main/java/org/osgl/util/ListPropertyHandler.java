package org.osgl.util;

import org.osgl.$;
import org.osgl.Lang;

class ListPropertyHandler extends PropertyHandlerBase {

    protected final Class<?> itemType;

    ListPropertyHandler(Class<?> itemType) {
        this.itemType = $.requireNotNull(itemType);
    }

    ListPropertyHandler(PropertyGetter.NullValuePolicy nullValuePolicy, Class<?> itemType) {
        super(nullValuePolicy);
        this.itemType = $.requireNotNull(itemType);
    }

    ListPropertyHandler(Lang.Function<Class<?>, Object> objectFactory,
                        Lang.Func2<String, Class<?>, ?> stringValueResolver,
                        Class<?> itemType) {
        super(objectFactory, stringValueResolver);
        this.itemType = $.requireNotNull(itemType);
    }

    ListPropertyHandler(Lang.Function<Class<?>, Object> objectFactory,
                        Lang.Func2<String, Class<?>, ?> stringValueResolver,
                        PropertyGetter.NullValuePolicy nullValuePolicy,
                        Class<?> itemType) {
        super(objectFactory, stringValueResolver, nullValuePolicy);
        this.itemType = $.requireNotNull(itemType);
    }

}
