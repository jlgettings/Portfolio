/*Jessica Gettings
CS6423 - Algorithmic Processes
Homework 6 - n-Queens problem
This program takes an input n and prints out an nxn "chessboard" with
n queens (Q) arranged so that no queen may attack any other. It also
prints out intermediate boards to help display the path it took to get
to the answer, and prints out an error for 2x2 and 3x3 chessboards (which
have no solution).
*/

#include <iostream>
#include <vector>

using namespace std;

//global variables
int n;          //board dimensions, total number of queens
bool allowed;   //passes test
char pqueen;    //for printing
vector<vector<bool>> board;     //initialized to nxn "board" (2D array)
vector<vector<int>> queens;     //list of "squares" containing queens

//functions
bool test(int i, int j);    //test single square
int count ();       //count queens on board
void retry();       //remove last queen placed and try the next available square (recursive--calls populate())
void populate(int i, int j);    //start from square [i][j] and place as many queens as possible (recursive--calls retry())
bool checkboard();  //confirm that solution is correct
void printboard();  //print solution

int main(){

    //input n
    cout << "Enter a positive integer: " << endl;
    cin >> n;

    //initialize empty nxn board
    for(int i=0; i<n; i++){
        vector<bool> vI;
        for(int j=0; j<n; j++){
            vI.push_back(false);
        }
        board.push_back(vI);
    }

    //populate/retry recursive calls, starting with square i=0, j=0
    populate(0,0);

    if(checkboard()){
        cout << "\nSolution:" << endl;
        printboard();
    }
    else{
        cout << "\nError: solution not found." << endl;
    }

    cout << "Press any key to exit." << endl;   //included because when I ran the .exe from another computer,
    char x;                                     //the console window closed too quickly to read the output
    cin >> x;

    return 1;
}

bool test(int i, int j){    //analyzes a square to see if a queen placed there can attack any preexisting queens
    allowed = true;     //assume a queen can be placed safely

    for(int k=0; k<n; k++){
        if(board[i][k] || board[k][j]){     //look for row and column attacks
            allowed=false;
        }
        //look for attacks on all four diagonals
        if(i-k>=0 && j-k>=0 && board[i-k][j-k]){
            allowed = false;
        }
        if(i+k<n && j+k<n && board[i+k][j+k]){
                allowed = false;
        }
        if(i-k>=0 && j+k<n && board[i-k][j+k]){
            allowed = false;
        }
        if(i+k<n && j-k>=0 && board[i+k][j-k]){
            allowed = false;
        }
    }
    return allowed;     //false if any attacks are possible, true otherwise
}

int count(){    //count queens on board

    int queens = 0;

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(board[i][j]){
                queens++;
            }
        }
    }
    return queens;
}

void retry(){
    vector<int> q = queens[queens.size()-1];
    queens.pop_back();  //remove last queen's square from queens vector
    int i = q[0];
    int j = q[1];
    board[i][j]=false;  //remove last queen from board

    cout << "Queen removed: " << endl;
    printboard();

    if(j<n-1){
        populate(i, j+1);   //populate starting from next square in row
    }
    else{
        populate(i+1, 0);   //move to new column and populate
    }
}

void populate(int i, int j){    //test and place as many queens as possible
    while(i<n){
        while(j<n){
            if(test(i, j)){     //if square is safe
                board[i][j]=true;   //place queen on safe square
                vector<int> vQ = {i, j};
                queens.push_back(vQ);   //add square's [i][j] coordinates to queens vector
            }
            j++;    //next square in row
        }
        i++;    //beginning of next column
        j=0;
    }
    cout << "Board populated: " << endl;
    printboard();

    if(count()<n && count()>0){  //if not enough queens have been placed AND the first queen has not been tried in every square
        retry();    //remove last queen and populate again
    }
}

bool checkboard(){
    int i, j;
    vector<int> q;

    if(queens.size()==0){
        return false;
    }

    for(int k=0; k<n; k++){ //check each set of coordinates in queens vector
        q = queens[k];
        i = q[0];
        j = q[1];
        board[i][j]=false;  //prevents the square being tested from providing a false positive
        if(!test(i,j)){
            return false;
        }
        else{
            board[i][j]=true;
        }
    }
    return true;
}

void printboard(){

     for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(board[i][j]){
                pqueen = 'Q';
            }
            else{
                pqueen = ' ';
            }
            cout << "[" << pqueen << "] ";
        }
        cout << endl;
    }
}
