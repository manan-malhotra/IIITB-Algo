# Masters Theorem

### Decreasing Functions

#### - T(n) = a T(n-b) + f(n)
> where,  a>0, b>0 
f(n)=O(n<sup>k</sup>)

> if a=1 -> O(n * f(n))
>Examples:
> 1) T(n) = T(n – 1 ) + 1  -> O(n)
> 2) T(n) = T(n – 1 ) + n  -> O(n<sup>2</sup>)
> 3) T(n) = T(n – 1 ) + log n  -> O(n log n )

> if a>1 -> O(f(n) * a<sup>n/b</sup>)
>Examples:
> 1) T(n) = 2T(n – 1 ) + 1 -> O(2<sup>n</sup>)
> 2) T(n) = 3T(n – 1 ) + 1 -> O(3<sup>n</sup>)
> 3) T(n) = 2T(n – 1 ) + n -> O(n * 2<sup>n</sup>)


> if a<1 -> O(f(n))


### Dividing Functions

#### - T(n) = a T(n/b) + f(n)
> where,  a>0, b>0 
>f(n)=O(n<sup>k</sup> * log<sup>p</sup>n)

> if log<sub>b</sub>a > k -> O(n<sup>log<sub>b</sub>a</sup>)

> if log<sub>b</sub>a = k
>> if p > -1 -> O(n<sup>k</sup> log<sup>p+1</sup>n)
>>   *Basically multiply by log n*
>
>> if p = -1 -> O(n<sup>k</sup> log log n) 
>
>> if p < -1 -> O(n<sup>k</sup>)

> if log<sub>b</sub>a < k
> 
>> if  p >= 0 -> O(n<sup>k</sup> log<sup>p</sup>n)
>
>> if p < 0 -> O(n<sup>k</sup>)