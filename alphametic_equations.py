from __future__ import division
from itertools import permutations
from re import findall
from string import maketrans

def solve(s):
    '''Find solutions to alphametic equations.

    >>> solve('SEND + MORE == MONEY')
    9567 + 1085 == 10652

    '''
    words = findall('[A-Za-z]+', s)
    chars = set(''.join(words))         # characters to be substituted
    assert len(chars) <= 10             # there are only ten possible digits
    firsts = set(w[0] for w in words)   # first letters of each of word
    chars = ''.join(firsts) + ''.join(chars - firsts)   
    n = len(firsts)                     # chars[:n] cannot be assigned zero
    for perm in permutations('0123456789', len(chars)):
        if '0' not in perm[:n]:
            trans = maketrans(chars, ''.join(perm))
            equation = s.translate(trans)
            try:
                if eval(equation):
                    print equation
            except ArithmeticError:
                pass

for alphametic in [
        'cyce + dupa == chuj'
      
    ]:
    print alphametic
    solve(alphametic)
    print