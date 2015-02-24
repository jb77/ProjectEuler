import Data.List (find)

solveSlow :: Maybe Int
solveSlow = find divisibleBy [1..]


divisibleBy:: Int ->  Bool
divisibleBy i = all (\x -> i `mod` x == 0) [1..20]


solveFast = foldl1 lcm [20,19..1]