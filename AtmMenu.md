7/9 概念8：方法命名與拆分原則

請列出 7/8 AtmMenu.java 可以拆成哪些方法，至少寫出 4 個方法名稱：

1. printAtmMenu()
   用途：負責印出 ATM 的主選單（1. 查詢餘額、2. 存款、3. 提款、0. 離開）。

2. checkBalance(int balance)
   用途：負責顯示使用者目前的帳戶餘額。

3. deposit(int balance, int amount)
   用途：處理存款邏輯，將存款金額加到總餘額中，並回傳更新後的餘額。

4. withdraw(int balance, int amount)
   用途：處理提款邏輯，包含檢查餘額是否足夠，扣除金額後回傳更新後的餘額。