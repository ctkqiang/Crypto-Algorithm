<<<<<<< HEAD
=======
import CryptoKit;

>>>>>>> Alternative
func hash(_ string: String) -> Int {
    let unicodeScalars = string.unicodeScalars.map {
        Int($0.value);
    }
    return unicodeScalars.reduce(0, +);
}

<<<<<<< HEAD
print("Calculated: ", hash("Hahahahaha"));
=======
let userInput = input("Enter a string: \n");
let inputData = Data(userInput.utf8)

print(inputData)
>>>>>>> Alternative
