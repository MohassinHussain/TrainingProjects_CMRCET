#include<iostream>
#include<map>
#include<utility>
#include<algorithm>
#include<vector>

using namespace std;


bool compareByBalance(const pair<int, int>& a,const pair<int, int>& b) {
    return a.second < b.second; 
}

int main(){
    int n; cin>>n;
    map<int, int> users;
    for(int i=0;i<n;i++){
        int accountNumber, balance;
        cin>>accountNumber>>balance;
        users.insert({accountNumber, balance});
     }
    int t;
    cin>>t;
    map<int, pair<int, long>> transactions;
    for(int i= 0;i<t;i++){
       int senderAccount, resAccount; cin>>senderAccount>>resAccount;
       long amountToSend; cin>>amountToSend;
       transactions.insert({senderAccount, {resAccount, amountToSend}});
       auto it = users.find(senderAccount);
       auto resIt = users.find(resAccount);
       if(it->second > amountToSend){
           cout<<"Success"<<endl;
           it->second -= amountToSend;
           resIt->second += amountToSend;
       }
       else {
           cout<<"Failure"<<endl;
       }
        
    }
    cout<<endl;
    vector<pair<int, int>> sortedUsers(users.begin(), users.end());
    sort(sortedUsers.begin(), sortedUsers.end(), compareByBalance);

    for (const auto& user : sortedUsers) {
        cout << user.first << " " << user.second << endl;
    }
    
    return 0;
}