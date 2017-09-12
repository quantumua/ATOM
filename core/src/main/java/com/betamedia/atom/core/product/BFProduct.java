package com.betamedia.atom.core.product;

import com.betamedia.atom.core.dsl.type.ProductType;

/**
 * @author Maksym Tsybulskyy
 *         Date: 9/12/17.
 */
public interface BFProduct extends ProductDependent {

    @Override
    default ProductType getType() {
        return ProductType.TP;
    }
}
