public class Account
{
private String owner;
private int balance;

public Account()
{
} // end constructor Account()

public void initialise(String name)
{
    owner = name;
    balance = 0;
} // end method initialise

public void deposit (int anAmount)
{
    balance = balance + anAmount;
} // end method deposit

public int withdraw (int anAmount)
{
    int amountWithdrawn;

    if (anAmount <= balance)
    amountWithdrawn = anAmount;
    else
    amountWithdrawn = balance;

    balance = balance - amountWithdrawn;

    return amountWithdrawn;
} // end method withdraw

public void print()
{
    System.out.println("Owner = "+ owner +
    " Balance = "+balance);
} // end method print

} // end class Account