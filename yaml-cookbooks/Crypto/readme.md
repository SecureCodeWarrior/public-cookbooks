# Crypto Recipes
## Approved Hash Functions
- FIPS 180
    - SHA-1 (160 bit output, legacy verifications only)
    - SHA-2 family:
        - SHA-224
        - SHA-256
        - SHA-384
        - SHA-512
        - SHA-512/224
        - SHA-512/256
- FIPS 202
    - SHA-3 family:
        - SHA3-224 
        - SHA3-256
        - SHA3-384 
        - SHA3-512
    - SHAKE128 and SHAKE256 (variable length, approved only for specific cases, see SP 800-185)
- SP 800-185
    - TupleHash (variable length, for tuples)
    - ParallelHash (variable length, hash contiguous, non-overlapping blocks of very long messages in parallel)

SHA3-$n$ offers $n$ bits of security against preimage and second-preimage attacks and $n/2$ bits of security against collision attacks
SHAKE-$n$ offers at $n$ bits of security against preimage and second-preimage attacks and also $n$ bits of security against collision attacks (assuming the digest is at least $2n$ bits long)

## Symmetric-key Algorithms
### Block Cipher Algorithms
- Not approved (legacy only)
    - DES
    - Triple DES/TDEA/2TDEA/3TDEA
    - SKIPJACK
- Approved
    - AES (depending on mode and IV, see SP 800-38 A-G)

### Hash-based Symmetric-key Algorithms
For HMAC any of the approved hash functions are approved. KMAC128 and KMAC256 (see SP 800-185) are also approved.

## Asymmetric-key Algorithms
### Digital Signatures
- DSA (to be removed in the future)
- ECDSA 
- RSA (RFC 8017, PKCS 1.5 or higher)
- EdDSA

Key sizes and pairs in FIPS 186, curves in SP 800-186.


## References
- [NIST.SP.800-175 B revision 1](https://nvlpubs.nist.gov/nistpubs/SpecialPublications/NIST.SP.800-175Br1.pdf) (2020)
- [Crypto Stack Exchange on SHAKE hash](https://crypto.stackexchange.com/questions/70565/shake-128-256-or-sha3-256-512) (2019)