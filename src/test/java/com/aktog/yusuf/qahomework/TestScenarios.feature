# Feature: Complete transaction
#
#  Background:
#    * url "https://https://www.e-bebek.com/cart"
#
#  Scenario: User tries to buy something when not Logged In
#
#    Given User not logged in
#    When User press purchase button
#    Then User gets redirected to the login page

#  Scenario: User tries to buy something
#
#      Given user logged in
#      Given user does not have any credit/bank cards saved
#      When User click purchase button
#      Then User gets redirected to the payment method page

#  Scenario: User tries to buy something
#
#      Given user logged in
#      Given user have some credit/bank cards saved
#      Given user have enough money to complete transaction
#      When User click purchase button
#      Then transaction completed status 200
#
#
 #  Scenario: User tries to buy something
#
#      Given user logged in
#      Given user have some credit/bank cards saved
#      Given user have not enough money to complete transaction
#      When User click purchase button
#      Then transaction gets denied
#
