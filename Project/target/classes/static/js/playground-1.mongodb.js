// MongoDB Playground
// Use Ctrl+Space inside a snippet or a string literal to trigger completions.

// The current database to use.
use("mainBanking");

db.getCollection('Users').deleteMany({});
db.getCollection('BankAccounts').deleteMany({});
db.getCollection('Transactions').deleteMany({});
db.getCollection('Budgets').deleteMany({});

db.getCollection('Users').insertMany([
  { userID: '1', username: 'test1', password: 'testpass1'},
  { userID: '2', username: 'test2', password: 'testpass2'},
  { userID: '3', username: 'test3', password: 'testpass3'},
  { userID: '4', username: 'test4', password: 'testpass4'},
  { userID: '5', username: 'test5', password: 'testpass5'},
  { userID: '6', username: 'test6', password: 'testpass6'},
  { userID: '7', username: 'test7', password: 'testpass7'},
  { userID: '8', username: 'test8', password: 'testpass8'},
  { userID: '9', username: 'test9', password: 'testpass9'},
  { userID: '10', username: 'test10', password: 'testpass10'}
]);

db.getCollection('BankAccounts').insertMany([
  { connectedUserID: '1', userID: 'test1', balance: 1000 },
]);

db.getCollection('Transactions').insertMany([
  { transactionID: '1', connectedBankAccountID: '1', sourceEntity: 'testlocation1', details: 'testdetails1', amountDollars: 100.00, transactionTime: ISODate("2023-01-01T00:00:00Z") },
]);

db.getCollection('Budgets').insertMany([
  { budgetID: '1', connectedUserID: '1', foodPercentage: 25, rentPercentage: 25, entertainmentPercentage: 25, transportationPercentage: 25 }
]);