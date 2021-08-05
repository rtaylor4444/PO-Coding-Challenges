def fizzbuzz(num: int) -> None:
    if num % 5 == 0 and num % 3 == 0:
        print("FizzBuzz")
    elif num % 5 == 0:
        print("Buzz")
    elif num % 3 == 0:
        print("Fizz")
    else:
        print(num)


if __name__ == '__main__':
    fizzbuzz(15)
    fizzbuzz(5)
    fizzbuzz(3)
    fizzbuzz(4)
