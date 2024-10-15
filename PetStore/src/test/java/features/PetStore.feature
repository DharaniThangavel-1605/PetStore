Feature: Add and delete a pet

Scenario: Access pet store

Given set up the pet store end point
Then Place the get request for available pets
Then Post new available pet to the store
Then Update pet status to sold
Then Delete the pet 