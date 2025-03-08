<%-- 
    Document   : canvas-search
    Created on : Mar 6, 2025, 10:30:39 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <div class="offcanvas offcanvas-end canvas-search" id="canvasSearch">
        <div class="canvas-wrapper">
            <header class="tf-search-head">
                <div class="title fw-5">
                    Search our site
                    <div class="close">
                        <span class="icon-close icon-close-popup" data-bs-dismiss="offcanvas" aria-label="Close"></span>
                    </div>
                </div>
                <div class="tf-search-sticky">
                    <form action="home" class="tf-mini-search-frm">
                        <input type="hidden" name="action" value="search"/>
                        <fieldset class="text">
                            <input type="text" placeholder="Search" class="" name="keyword" tabindex="0" value=""
                                aria-required="true" required="">
                        </fieldset>
                        <button class="" type="submit">
                            <i class="icon-search"></i>
                        </button>
                    </form>
                </div>
            </header>
            <div class="canvas-body p-0">
                <div class="tf-search-content">
                    <div class="tf-cart-hide-has-results">
                        <div class="tf-col-quicklink">
                            <div class="tf-search-content-title fw-5">Quick link</div>
                            <ul class="tf-quicklink-list">
                                <li class="tf-quicklink-item">
                                    <a href="home?action=men" class="">Men</a>
                                </li>
                                <li class="tf-quicklink-item">
                                    <a href="home?action=women" class="">Women</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tf-col-content">
                            
                </div>
            </div>
        </div>
    </div>
