package screen

import extensions.getNotEmptyString

/*
Step 1. 장바구니에 추가한 상품 관리
Step 2. 사용자 입력값 요청 처리 공통화
Step 3. 프로젝트 전역에서 참조하는 상수
 */


class ShoppingCategory : Screen() {

    public fun showCategories() {
        ScreenStack.push(this)
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }
        println("=> 장바구니로 이동하시려면 #을 입력해주세요.")

        val selectedCategory = readLine().getNotEmptyString()
        if (selectedCategory == "#") {
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        } else {
            if (categories.contains(selectedCategory)) {
                val shoppingProductList = ShoppingProductList(selectedCategory)
                shoppingProductList.showProducts()
            }else{

                showErrorMessage(selectedCategory)

            }

        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory] : 존재하지 않는 카테고리 입니다. 다시 입력해 주세요.")
        showCategories()
    }

}