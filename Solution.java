public class Solution {
  public static void main(String[] args) {
    int array[][] = {
        { 2, 8, 8, 2 },
        { 0, 0, 16, 2 },
        { 8, 0, 0, 0 },
        { 8, 8, 8, 2 } };

    method(array, "right");
  }

  public static boolean power(int number) {
    int arr[] = { 0, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 };
    for (int i = 0; i < arr.length; i++) {
      if (number == arr[i]) {
        return true;
      }
    }
    return false;

  }

  public static void method(int[][] array, String direction) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if (power(array[i][j]) == false) {
          array[i][j] = 0;
        }
      }
    }
    if (direction == "right") {
      for (int i = array.length - 1; i >= 0; i--) {
        for (int j = array[i].length - 1; j >= 0; j--) {
          if (j == array.length - 1 && array[i][j] != 0
              && array[i][array.length - 1] != array[i][array.length - 2]) {
            int k = j;
            while (k >= 1) {
              k--;
              if (array[i][k] == 0) {
                continue;
              }
              if (k > 0 && array[i][k] != 0) {
                if (array[i][array.length - 1] == array[i][k]) {
                  array[i][array.length - 1] = array[i][array.length - 1] * 2;
                  array[i][k] = 0;
                }
                break;
              } else if (array[i][array.length - 1] == array[i][k]) {
                array[i][array.length - 1] = array[i][array.length - 1] * 2;
                array[i][k] = 0;
                break;
              }
            }

          }

          else if (j >= 1) {
            if (array[i][j] == array[i][j - 1]) {
              array[i][j] = array[i][j - 1] + array[i][j];
              array[i][j - 1] = 0;
            }

            if ((array[i][j - 1] == 0 && array[i][j] != 0)) {
              int k = j;
              int p = i;
              while (j > 1) {
                j--;
                if (array[p][k] == array[i][j - 1]) {
                  array[p][k] = array[p][k] + array[i][j - 1];
                  array[i][j - 1] = 0;
                  break;
                } else {
                  break;
                }
              }
            }
          }
        }

      }

      for (int i = array.length - 1; i >= 0; i--) {
        for (int j = array[i].length - 1; j >= 0; j--) {
          if (array[i][j] == 0) {
            int k = j;
            int a = j;
            while (a >= 1) {
              a--;
              if (array[i][a] != 0) {
                array[i][k] = array[i][a];
                array[i][a] = 0;
                break;
              }

            }
          }
        }
      }
    }

    if (direction == "left") {
      for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
          if (j == 0 && array[i][j] != 0 && array[i][0] != array[i][1]) {
            int k = j;
            while (k <= array.length - 2) {
              k++;
              if (array[i][k] == 0) {
                continue;
              }
              if (k < array.length - 1 && array[i][k] != 0) {
                if (array[i][0] == array[i][k]) {
                  array[i][0] = array[i][0] * 2;
                  array[i][k] = 0;
                }
                break;
              } else if (array[i][0] == array[i][k]) {
                array[i][0] = array[i][0] * 2;
                array[i][k] = 0;
                break;
              }
            }
          } else if (j <= array.length - 2) {
            if (array[i][j] == array[i][j + 1]) {
              array[i][j] = array[i][j + 1] + array[i][j];
              array[i][j + 1] = 0;
            } else if (array[i][j + 1] == 0 && array[i][j] != 0) {
              int k = j;
              int p = i;

              while (j < array.length - 2) {
                j++;
                if (array[i][j + 1] != array[p][k]) {
                  break;

                }
                if (array[p][k] == array[i][j + 1]) {
                  array[p][k] = array[i][k] + array[i][j + 1];
                  array[i][j + 1] = 0;
                  break;
                }
              }
            }
          }
        }
      }
      for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
          if (array[i][j] == 0) {
            int k = j;
            int a = j;
            while (a < array[i].length - 1) {
              a++;
              if (array[i][a] != 0) {
                array[i][k] = array[i][a];
                array[i][a] = 0;
                break;
              }
            }
          }
        }
      }
    }

    if (direction == "up") {
      for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
          if (i == 0 && array[i][j] != 0 && array[0][j] != array[1][j]) {
            int k = i;
            while (k <= array.length - 2) {
              k++;
              if (array[k][j] == 0) {
                continue;
              }
              if (k < array.length - 1 && array[k][j] != 0) {
                if (array[0][j] == array[k][j]) {
                  array[0][j] = array[0][j] * 2;
                  array[k][j] = 0;
                }
                break;
              } else if (array[0][j] == array[k][j]) {
                array[0][j] = array[0][j] * 2;
                array[k][j] = 0;
                break;
              }
            }
          } else if (i <= array.length - 2) {
            if (array[i][j] == array[i + 1][j]) {
              array[i][j] = array[i + 1][j] + array[i][j];
              array[i + 1][j] = 0;
            } else if (array[i + 1][j] == 0 && array[i][j] != 0) {
              int k = j;
              int p = i;

              while (i < array.length - 2) {
                i++;
                if (array[i + 1][j] != array[p][k]) {
                  break;

                }
                if (array[p][k] == array[i + 1][j]) {
                  array[p][k] = array[p][j] + array[i + 1][j];
                  array[i + 1][j] = 0;
                  break;
                }
              }
            }
          }
        }
      }
      for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
          if (array[i][j] == 0) {
            int k = i;
            int a = i;
            while (a < array.length - 1) {
              a++;
              if (array[a][j] != 0) {
                array[k][j] = array[a][j];
                array[a][j] = 0;
                break;
              }
            }
          }
        }
      }
    }

    if (direction == "down") {
      for (int i = array.length - 1; i >= 0; i--) {
        for (int j = array[i].length - 1; j >= 0; j--) {
          if (i == array.length - 1 && array[i][j] != 0
              && array[array.length - 1][j] != array[array.length - 2][j]) {
            int k = i;
            while (k >= 1) {
              k--;
              if (array[k][j] == 0) {
                continue;
              }
              if (k > 0 && array[k][j] != 0) {
                if (array[array.length - 1][j] == array[k][j]) {
                  array[array.length - 1][j] = array[array.length - 1][j] * 2;
                  array[k][j] = 0;
                }
                break;
              } else if (array[array.length - 1][j] == array[k][j]) {
                array[array.length - 1][j] = array[array.length - 1][j] * 2;
                array[k][j] = 0;
                break;
              }
            }

          }

          else if (i >= 1) {
            if (array[i][j] == array[i - 1][j]) {
              array[i][j] = array[i - 1][j] + array[i][j];
              array[i - 1][j] = 0;
            }

            if ((array[i - 1][j] == 0 && array[i][j] != 0)) {
              int k = j;
              int p = i;
              while (i > 1) {
                i--;
                if (array[p][k] == array[i - 1][j]) {
                  array[p][k] = array[p][k] + array[i - 1][j];
                  array[i - 1][j] = 0;
                  break;
                } else {
                  break;
                }
              }
            }
          }
        }

      }

      for (int i = array.length - 1; i >= 0; i--) {
        for (int j = array[i].length - 1; j >= 0; j--) {
          if (array[i][j] == 0) {
            int k = i;
            int a = i;
            while (a >= 1) {
              a--;
              if (array[a][j] != 0) {
                array[k][j] = array[a][j];
                array[a][j] = 0;
                break;
              }

            }
          }
        }
      }
    }

    for (int[] ints : array) {
      int ctt = 0;
      for (int anInt : ints) {
        if (ctt == array.length - 1) {
          System.out.println(anInt);
        } else {
          System.out.print(anInt + " ");
          ctt++;
        }
      }
    }

  }
}
