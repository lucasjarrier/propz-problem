import http from "./config";

export const checkPerfectNumber = async (number) => {
  return http().get(`/problem/check-perfect/${number}`);
};

export const findPerfectNumbers = async (start, end) => {
  return http().get(`/problem/find-perfect?start=${start}&end=${end}`);
};
