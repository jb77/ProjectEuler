

solve a = maximum $ filter (\x -> a `mod` x == 0) $ primes a -- (round $ sqrt a)

primes a = sieve [2..a] 

sieve :: [Integer] -> [Integer] 
sieve [] = []
sieve (p:xs) = p : sieve [x | x <-xs, x `mod` p /=0]
