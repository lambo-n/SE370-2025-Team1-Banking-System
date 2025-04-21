// MongoDB Playground
// Use Ctrl+Space inside a snippet or a string literal to trigger completions.

// The current database to use.
use("mainBanking");

db.getCollection('Users').deleteMany({});

db.getCollection('Users').insertMany([
    { '_userID': '1', username: 'test1', password: 'testpass1'},
    { '_userID': '2', username: 'test2', password: 'testpass2'},
    { '_userID': '3', username: 'test3', password: 'testpass3'},
    { '_userID': '4', username: 'test4', password: 'testpass4'},
    { '_userID': '5', username: 'test5', password: 'testpass5'},
    { '_userID': '6', username: 'test6', password: 'testpass6'},
    { '_userID': '7', username: 'test7', password: 'testpass7'},
    { '_userID': '8', username: 'test8', password: 'testpass8'},
    { '_userID': '9', username: 'test9', password: 'testpass9'},
    { '_userID': '10', username: 'test10', password: 'testpass10'}
  ]);