
sumEvens = sum . filter (even) $ lt4M

lt4M = takeWhile (<=4000000) $ fib 1 2

fib :: Int -> Int ->[Int] 
fib x y = x : fib y (x+y)

-- or using list comprehension
lc = sum [ x | x <- takeWhile (<=4000000) $ fib 1 2, even x]