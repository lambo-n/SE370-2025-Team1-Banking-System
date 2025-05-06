// MongoDB Playground
// Use Ctrl+Space inside a snippet or a string literal to trigger completions.

// The current database to use.
use("mainBanking");

db.getCollection('Users').deleteMany({});
db.getCollection('BankAccounts').deleteMany({});
db.getCollection('Transactions').deleteMany({});
db.getCollection('Budgets').deleteMany({});

db.getCollection('Users').insertMany([
  { userID: 'U1', username: 'test1', password: 'testpass1', name: 'Test User1', email: 'test@mail.com', socSecurity: '123-45-6789', phoneNum: '1234567890', address: '123 Test St, Test City, TX 12345'},
  { userID: 'U2', username: 'test2', password: 'testpass2'},
  { userID: 'U3', username: 'test3', password: 'testpass3'},
  { userID: 'U4', username: 'test4', password: 'testpass4'},
  { userID: 'U5', username: 'test5', password: 'testpass5'},
  { userID: 'U6', username: 'test6', password: 'testpass6'},
  { userID: 'U7', username: 'test7', password: 'testpass7'},
  { userID: 'U8', username: 'test8', password: 'testpass8'},
  { userID: 'U9', username: 'test9', password: 'testpass9'},
  { userID: 'U10', username: 'test10', password: 'testpass10'}
]);

db.getCollection('BankAccounts').insertMany([
  { bankAccountID: 'BA1', bankAccountName: 'Chase', connectedUserID: 'cUtest1', balance: 1000 },
  { bankAccountID: 'BA2', bankAccountName: 'Bank of America', connectedUserID: 'cUtest1', balance: 2000 },
  { bankAccountID: 'BA3', bankAccountName: 'Wells Fargo', connectedUserID: 'cUtest1', balance: 5000 },
  { bankAccountID: 'BA4', bankAccountName: 'US Bank', connectedUserID: 'cUtest1', balance: 0 },
]);

db.getCollection('Transactions').insertMany([
  { transactionID: 'T1', connectedBankAccountID: 'cBA1', sourceEntity: 'testlocation1', details: 'testdetails1', amountDollars: 100.00, transactionTime: ISODate("2023-01-01T00:00:00Z") },
]);

db.getCollection('Budgets').insertMany([
  { budgetID: 'BU1', connectedUserID: 'cU1', foodPercentage: 25, rentPercentage: 25, entertainmentPercentage: 25, transportationPercentage: 25 }
]);