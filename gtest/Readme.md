# INTEGRACIÓN GTEST VISUAL STUDIO


![INSTALACION](img/img1.jpg)
Para poder usar gtest hay que tener instalado 


```c++
TEST(AccountTest, BankAccountStartsEmpty)
{
	BankAccount account;
	EXPECT_EQ(0, account.balance);
}

TEST_F(BankAccountTest, CanDepositMoney)
{
	account->deposit(100);
	EXPECT_EQ(100, account->balance);
}

TEST_P(WithdrawAccountTest, FinalBalance)
{
	auto as = GetParam();
	auto success = account->withdraw(as.withdraw_amount);
	EXPECT_EQ(as.final_balance, account->balance);
	EXPECT_EQ(as.success, success);
}

INSTANTIATE_TEST_CASE_P(Default, WithdrawAccountTest,
	testing::Values(
		account_state{ 100,50,50,true },
		account_state{ 100,200,100,false }
));
```