import CryptoKit;

func hash(_ string: String) -> Int {
    let unicodeScalars = string.unicodeScalars.map {
        Int($0.value);
    }
    return unicodeScalars.reduce(0, +);
}

let userInput = input("Enter a string: \n");
let inputData = Data(userInput.utf8)

print(inputData)