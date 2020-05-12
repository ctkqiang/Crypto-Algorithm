#include <stdio.h>
/**
 * Copyright 2020 © John Melody Me
 * Licensed under the John Melody Me, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
int main () {
      int i;
      int x;
      char str[100];

      printf("\n Please Enter a String:  ");
      gets(str);
      printf("\n Please Choose Following Option: \n");
      printf("1= Encrypt String. \n");
      printf("2= Decrypt String. \n");
      scanf("%d, &x");

      switch(x) {
            case 1:
                  for(i = 0; (i < 100 && str[i] != '\0'); i++) {
                        str[i] = str[i] + 3;
                  }
                  printf("\n Encrypted String: %s\n", str);
                  break;
            case 2:
                  for (i = 0; (i < 100 && str[i] != '\0'); i++) {
                        str[i] = str[i] - 3;
                  }
                  printf("\n Decrypted String: %s\n", str);
                  break;
            default:
            printf("\n Error \n");
      }

      return 0;
}