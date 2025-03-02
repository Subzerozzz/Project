<%-- 
    Document   : best-seller
    Created on : Feb 22, 2025, 4:12:13 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="flat-spacing-2 pt_0">
    <div class="container">
        <div class="flat-title flex-row justify-content-between px-0">
            <span class="title wow fadeInUp" data-wow-delay="0s">Best Seller</span>
            <div class="box-sw-navigation">
                <div class="nav-sw square nav-next-slider nav-next-product"><span class="icon icon-arrow1-left"></span></div>
                <div class="nav-sw square nav-prev-slider nav-prev-product"><span class="icon icon-arrow1-right"></span></div>
            </div>
        </div>
        <div class="hover-sw-nav hover-sw-2">
            <div dir="ltr" class="swiper tf-sw-product-sell wrap-sw-over" data-preview="4" data-tablet="3" data-mobile="2" data-space-lg="30" data-space-md="15" data-pagination="2" data-pagination-md="3" data-pagination-lg="3">
                <div class="swiper-wrapper">
                    <div class="swiper-slide" lazy="true">
                        <div class="card-product style-2">
                            <div class="card-product-wrapper">
                                <a href="product-detail.html" class="product-img">
                                    <img class="lazyload img-product" data-src="${pageContext.request.contextPath}/images/products/orange-1.jpg" src="${pageContext.request.contextPath}/images/products/orange-1.jpg" alt="image-product">
                                    <img class="lazyload img-hover" data-src="${pageContext.request.contextPath}/images/products/white-1.jpg" src="${pageContext.request.contextPath}/images/products/white-1.jpg" alt="image-product">
                                </a>
                                <div class="list-product-btn column-left">
                                    <a href="javascript:void(0);" class="box-icon wishlist bg_white btn-icon-action">
                                        <span class="icon icon-heart"></span>
                                        <span class="tooltip">Add to Wishlist</span>
                                        <span class="icon icon-delete"></span>
                                    </a>
                                    <a href="#compare" data-bs-toggle="offcanvas" aria-controls="offcanvasLeft" class="box-icon bg_white compare btn-icon-action">
                                        <span class="icon icon-compare"></span>
                                        <span class="tooltip">Add to Compare</span>
                                        <span class="icon icon-check"></span>
                                    </a>
                                </div>
                                <div class="list-product-btn absolute-3">
                                    <a href="#quick_add" data-bs-toggle="modal" class="box-icon quick-add style-2">
                                        <span class="icon icon-bag"></span>
                                        <span class="text">QUICK ADD</span>
                                    </a>
                                    <a href="#quick_view" data-bs-toggle="modal" class="box-icon quickview style-2">
                                        <span class="icon icon-view"></span>
                                        <span class="text">QUICK VIEW</span>
                                    </a>
                                </div>
                                <div class="size-list style-2">
                                    <span>S</span>
                                    <span>M</span>
                                    <span>L</span>
                                    <span>XL</span>
                                </div>
                                <div class="on-sale-wrap text-end">
                                    <div class="on-sale-item">-33%</div>
                                </div>
                                <div class="countdown-box">
                                    <div class="js-countdown" data-timer="1007500" data-labels="d :,h :,m :,s"></div>
                                </div>
                            </div>
                            <div class="card-product-info">
                                <a href="product-detail.html" class="title link">Ribbed Tank Top</a>
                                <span class="price">$16.95</span>
                                <ul class="list-color-product">
                                    <li class="list-color-item color-swatch active">
                                        <span class="tooltip">Orange</span>
                                        <span class="swatch-value bg_orange-3"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/orange-1.jpg" src="${pageContext.request.contextPath}/images/products/orange-1.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">Black</span>
                                        <span class="swatch-value bg_dark"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/black-1.jpg" src="${pageContext.request.contextPath}/images/products/black-1.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">White</span>
                                        <span class="swatch-value bg_white"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/white-1.jpg" src="${pageContext.request.contextPath}/images/products/white-1.jpg" alt="image-product">
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide" lazy="true">
                        <div class="card-product style-2">
                            <div class="card-product-wrapper">
                                <a href="product-detail.html" class="product-img">
                                    <img class="lazyload img-product" data-src="${pageContext.request.contextPath}/images/products/brown.jpg" src="${pageContext.request.contextPath}/images/products/brown.jpg" alt="image-product">
                                    <img class="lazyload img-hover" data-src="${pageContext.request.contextPath}/images/products/purple.jpg" src="${pageContext.request.contextPath}/images/products/purple.jpg" alt="image-product">
                                </a>
                                <div class="list-product-btn column-left">
                                    <a href="javascript:void(0);" class="box-icon wishlist bg_white btn-icon-action">
                                        <span class="icon icon-heart"></span>
                                        <span class="tooltip">Add to Wishlist</span>
                                        <span class="icon icon-delete"></span>
                                    </a>
                                    <a href="#compare" data-bs-toggle="offcanvas" aria-controls="offcanvasLeft" class="box-icon bg_white compare btn-icon-action">
                                        <span class="icon icon-compare"></span>
                                        <span class="tooltip">Add to Compare</span>
                                        <span class="icon icon-check"></span>
                                    </a>
                                </div>
                                <div class="list-product-btn absolute-3">
                                    <a href="#quick_add" data-bs-toggle="modal" class="box-icon quick-add style-2">
                                        <span class="icon icon-bag"></span>
                                        <span class="text">QUICK ADD</span>
                                    </a>
                                    <a href="#quick_view" data-bs-toggle="modal" class="box-icon quickview style-2">
                                        <span class="icon icon-view"></span>
                                        <span class="text">QUICK VIEW</span>
                                    </a>
                                </div>
                                <div class="size-list style-2">
                                    <span>S</span>
                                    <span>M</span>
                                    <span>L</span>
                                    <span>XL</span>
                                </div>

                            </div>
                            <div class="card-product-info">
                                <a href="product-detail.html" class="title link">Ribbed modal T-shirt</a>
                                <span class="price">From $18.95</span>
                                <ul class="list-color-product">
                                    <li class="list-color-item color-swatch active">
                                        <span class="tooltip">Brown</span>
                                        <span class="swatch-value bg_brown"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/brown.jpg" src="${pageContext.request.contextPath}/images/products/brown.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">Light Purple</span>
                                        <span class="swatch-value bg_purple"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/purple.jpg" src="${pageContext.request.contextPath}/images/products/purple.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">Light Green</span>
                                        <span class="swatch-value bg_light_green"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/green.jpg" src="${pageContext.request.contextPath}/images/products/green.jpg" alt="image-product">
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide" lazy="true">
                        <div class="card-product style-2">
                            <div class="card-product-wrapper">
                                <a href="product-detail.html" class="product-img">
                                    <img class="lazyload img-product" data-src="${pageContext.request.contextPath}/images/products/white-3.jpg" src="${pageContext.request.contextPath}/images/products/white-3.jpg" alt="image-product">
                                    <img class="lazyload img-hover" data-src="${pageContext.request.contextPath}/images/products/white-4.jpg" src="${pageContext.request.contextPath}/images/products/white-4.jpg" alt="image-product">
                                </a>
                                <div class="list-product-btn column-left">
                                    <a href="javascript:void(0);" class="box-icon wishlist bg_white btn-icon-action">
                                        <span class="icon icon-heart"></span>
                                        <span class="tooltip">Add to Wishlist</span>
                                        <span class="icon icon-delete"></span>
                                    </a>
                                    <a href="#compare" data-bs-toggle="offcanvas" aria-controls="offcanvasLeft" class="box-icon bg_white compare btn-icon-action">
                                        <span class="icon icon-compare"></span>
                                        <span class="tooltip">Add to Compare</span>
                                        <span class="icon icon-check"></span>
                                    </a>
                                </div>
                                <div class="list-product-btn absolute-2">
                                    <a href="#quick_add" data-bs-toggle="modal" class="box-icon quick-add style-2">
                                        <span class="icon icon-bag"></span>
                                        <span class="text">QUICK ADD</span>
                                    </a>
                                    <a href="#quick_view" data-bs-toggle="modal" class="box-icon quickview style-2">
                                        <span class="icon icon-view"></span>
                                        <span class="text">QUICK VIEW</span>
                                    </a>
                                </div>
                            </div>
                            <div class="card-product-info">
                                <a href="product-detail.html" class="title link">Oversized Printed T-shirt</a>
                                <span class="price">$10.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide" lazy="true">
                        <div class="card-product style-2">
                            <div class="card-product-wrapper">
                                <a href="product-detail.html" class="product-img">
                                    <img class="lazyload img-product" data-src="${pageContext.request.contextPath}/images/products/white-2.jpg" src="${pageContext.request.contextPath}/images/products/white-2.jpg" alt="image-product">
                                    <img class="lazyload img-hover" data-src="${pageContext.request.contextPath}/images/products/pink-1.jpg" src="${pageContext.request.contextPath}/images/products/pink-1.jpg" alt="image-product">
                                </a>
                                <div class="list-product-btn column-left">
                                    <a href="javascript:void(0);" class="box-icon wishlist bg_white btn-icon-action">
                                        <span class="icon icon-heart"></span>
                                        <span class="tooltip">Add to Wishlist</span>
                                        <span class="icon icon-delete"></span>
                                    </a>
                                    <a href="#compare" data-bs-toggle="offcanvas" aria-controls="offcanvasLeft" class="box-icon bg_white compare btn-icon-action">
                                        <span class="icon icon-compare"></span>
                                        <span class="tooltip">Add to Compare</span>
                                        <span class="icon icon-check"></span>
                                    </a>
                                </div>
                                <div class="list-product-btn absolute-3">
                                    <a href="#quick_add" data-bs-toggle="modal" class="box-icon quick-add style-2">
                                        <span class="icon icon-bag"></span>
                                        <span class="text">QUICK ADD</span>
                                    </a>
                                    <a href="#quick_view" data-bs-toggle="modal" class="box-icon quickview style-2">
                                        <span class="icon icon-view"></span>
                                        <span class="text">QUICK VIEW</span>
                                    </a>
                                </div>
                                <div class="size-list style-2">
                                    <span>S</span>
                                    <span>M</span>
                                    <span>L</span>
                                    <span>XL</span>
                                </div>
                            </div>
                            <div class="card-product-info">
                                <a href="product-detail.html" class="title link">Oversized Printed T-shirt</a>
                                <span class="price">$16.95</span>
                                <ul class="list-color-product">
                                    <li class="list-color-item color-swatch active">
                                        <span class="tooltip">White</span>
                                        <span class="swatch-value bg_white"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/white-2.jpg" src="${pageContext.request.contextPath}/images/products/white-2.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">Pink</span>
                                        <span class="swatch-value bg_purple"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/pink-1.jpg" src="${pageContext.request.contextPath}/images/products/pink-1.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">Black</span>
                                        <span class="swatch-value bg_dark"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/black-2.jpg" src="${pageContext.request.contextPath}/images/products/black-2.jpg" alt="image-product">
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide" lazy="true">
                        <div class="card-product style-2">
                            <div class="card-product-wrapper">
                                <a href="product-detail.html" class="product-img">
                                    <img class="lazyload img-product" data-src="${pageContext.request.contextPath}/images/products/light-green-1.jpg" src="${pageContext.request.contextPath}/images/products/light-green-1.jpg" alt="image-product">
                                    <img class="lazyload img-hover" data-src="${pageContext.request.contextPath}/images/products/light-green-2.jpg" src="${pageContext.request.contextPath}/images/products/light-green-2.jpg" alt="image-product">
                                </a>
                                <div class="list-product-btn column-left">
                                    <a href="javascript:void(0);" class="box-icon wishlist bg_white btn-icon-action">
                                        <span class="icon icon-heart"></span>
                                        <span class="tooltip">Add to Wishlist</span>
                                        <span class="icon icon-delete"></span>
                                    </a>
                                    <a href="#compare" data-bs-toggle="offcanvas" aria-controls="offcanvasLeft" class="box-icon bg_white compare btn-icon-action">
                                        <span class="icon icon-compare"></span>
                                        <span class="tooltip">Add to Compare</span>
                                        <span class="icon icon-check"></span>
                                    </a>
                                </div>
                                <div class="list-product-btn absolute-3">
                                    <a href="#quick_add" data-bs-toggle="modal" class="box-icon quick-add style-2">
                                        <span class="icon icon-bag"></span>
                                        <span class="text">QUICK ADD</span>
                                    </a>
                                    <a href="#quick_view" data-bs-toggle="modal" class="box-icon quickview style-2">
                                        <span class="icon icon-view"></span>
                                        <span class="text">QUICK VIEW</span>
                                    </a>
                                </div>
                                <div class="size-list style-2">
                                    <span>S</span>
                                    <span>M</span>
                                    <span>L</span>
                                    <span>XL</span>
                                </div>
                            </div>
                            <div class="card-product-info">
                                <a href="#" class="title link">Loose Fit Sweatshirt</a>
                                <span class="price">$10.00</span>
                                <ul class="list-color-product">
                                    <li class="list-color-item color-swatch active">
                                        <span class="tooltip">Light Green</span>
                                        <span class="swatch-value bg_light-green"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/light-green-1.jpg" src="${pageContext.request.contextPath}/images/products/light-green-1.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">Black</span>
                                        <span class="swatch-value bg_dark"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/black-3.jpg" src="${pageContext.request.contextPath}/images/products/black-3.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">Blue</span>
                                        <span class="swatch-value bg_blue-2"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/blue.jpg" src="${pageContext.request.contextPath}/images/products/blue.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">Dark Blue</span>
                                        <span class="swatch-value bg_dark-blue"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/dark-blue.jpg" src="${pageContext.request.contextPath}/images/products/dark-blue.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">White</span>
                                        <span class="swatch-value bg_white"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/white-6.jpg" src="${pageContext.request.contextPath}/images/products/white-6.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">Light Grey</span>
                                        <span class="swatch-value bg_light-grey"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/light-grey.jpg" src="${pageContext.request.contextPath}/images/products/light-grey.jpg" alt="image-product">
                                    </li>
                                </ul>
                            </div>
                        </div>  
                    </div>
                    <div class="swiper-slide" lazy="true">
                        <div class="card-product style-2">
                            <div class="card-product-wrapper">
                                <a href="product-detail.html" class="product-img">
                                    <img class="lazyload img-product" data-src="${pageContext.request.contextPath}/images/products/black-4.jpg" src="${pageContext.request.contextPath}/images/products/black-4.jpg" alt="image-product">
                                    <img class="lazyload img-hover" data-src="${pageContext.request.contextPath}/images/products/black-5.jpg" src="${pageContext.request.contextPath}/images/products/black-5.jpg" alt="image-product">
                                </a>
                                <div class="list-product-btn column-left">
                                    <a href="javascript:void(0);" class="box-icon wishlist bg_white btn-icon-action">
                                        <span class="icon icon-heart"></span>
                                        <span class="tooltip">Add to Wishlist</span>
                                        <span class="icon icon-delete"></span>
                                    </a>
                                    <a href="#compare" data-bs-toggle="offcanvas" aria-controls="offcanvasLeft" class="box-icon bg_white compare btn-icon-action">
                                        <span class="icon icon-compare"></span>
                                        <span class="tooltip">Add to Compare</span>
                                        <span class="icon icon-check"></span>
                                    </a>
                                </div>
                                <div class="list-product-btn absolute-3">
                                    <a href="#quick_add" data-bs-toggle="modal" class="box-icon quick-add style-2">
                                        <span class="icon icon-bag"></span>
                                        <span class="text">QUICK ADD</span>
                                    </a>
                                    <a href="#quick_view" data-bs-toggle="modal" class="box-icon quickview style-2">
                                        <span class="icon icon-view"></span>
                                        <span class="text">QUICK VIEW</span>
                                    </a>
                                </div>
                                <div class="size-list style-2">
                                    <span>S</span>
                                    <span>M</span>
                                    <span>L</span>
                                    <span>XL</span>
                                </div>
                            </div>
                            <div class="card-product-info">
                                <a href="#" class="title link">Regular Fit Oxford Shirt</a>
                                <span class="price">$10.00</span>
                                <ul class="list-color-product">
                                    <li class="list-color-item color-swatch active">
                                        <span class="tooltip">Black</span>
                                        <span class="swatch-value bg_dark"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/black-4.jpg" src="${pageContext.request.contextPath}/images/products/black-4.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">Dark Blue</span>
                                        <span class="swatch-value bg_dark-blue"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/dark-blue-2.jpg" src="${pageContext.request.contextPath}/images/products/dark-blue-2.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">Beige</span>
                                        <span class="swatch-value bg_beige"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/beige.jpg" src="${pageContext.request.contextPath}/images/products/beige.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">Light Blue</span>
                                        <span class="swatch-value bg_light-blue"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/light-blue.jpg" src="${pageContext.request.contextPath}/images/products/light-blue.jpg" alt="image-product">
                                    </li>
                                    <li class="list-color-item color-swatch">
                                        <span class="tooltip">White</span>
                                        <span class="swatch-value bg_white"></span>
                                        <img class="lazyload" data-src="${pageContext.request.contextPath}/images/products/white-7.jpg" src="${pageContext.request.contextPath}/images/products/white-7.jpg" alt="image-product">
                                    </li>
                                </ul>
                            </div>
                        </div>  
                    </div>
                </div>
            </div>
            <div class="nav-sw nav-next-slider nav-next-product box-icon w_46 round"><span class="icon icon-arrow-left"></span></div>
            <div class="nav-sw nav-prev-slider nav-prev-product box-icon w_46 round"><span class="icon icon-arrow-right"></span></div>
        </div>
    </div>
</section>
