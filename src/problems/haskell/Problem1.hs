import Data.List (nub,union)

-- 1st effort
p1 = let
    t = filter (\x -> x `mod` 3 == 0) 
    f = filter (\x -> x `mod` 5 == 0) 
    in sum $ nub $ t [1..999] ++ f [1..999] 

-- Use built-in ranges more
p1' = sum $ [3,6..999] `union` [5,10..999]    

-- Using list comprehension
p1'' = sum [ x | x<-[1..999], x `mod` 5==0 || x `mod` 3==0]